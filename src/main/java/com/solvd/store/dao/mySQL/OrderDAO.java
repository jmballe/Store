package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IOrderDAO;
import com.solvd.store.models.Order;
import com.solvd.store.models.Position;
import com.solvd.store.utils.ConnectionPool;

import java.sql.*;

public class OrderDAO extends MySQLDAO implements IOrderDAO {
    private final static String INSERT = "INSERT INTO `order` (customer_id, order_date, total_price, shipping_address_id, employee_id, order_status_id) VALUES(?,?,?,?,?,?)";
    private final static String UPDATE = "UPDATE `order` SET customer_id = ?, order_date = ?, total_price = ?, shipping_address_id = ?, employee_id = ?, order_status_id = ? WHERE order_id = ?";
    private final static String DELETE = "DELETE FROM `order` WHERE order_id = ?";
    private final static String GETBYID = "SELECT order_id, customer_id, order_date, total_price, shipping_address_id, employee_id, order_status_id FROM `order` WHERE order_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);
    @Override
    public Order getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Order order = new Order();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GETBYID)){
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                order.setOrder_id(result.getInt(1));
                order.setCustomer_id(result.getInt(2));
                order.setOrder_date(result.getDate(3).toLocalDate());
                order.setTotal_price(result.getDouble(4));
                order.setShipping_address_id(result.getInt(5));
                order.setEmployees_id(result.getInt(6));
                order.setOrder_Status_id(result.getInt(7));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return order;
    }

    @Override
    public void update(Order entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, entity.getCustomer_id());
            preparedStatement.setDate(2, Date.valueOf(entity.getOrder_date()));
            preparedStatement.setDouble(3, entity.getTotal_price());
            preparedStatement.setInt(4, entity.getShipping_address_id());
            preparedStatement.setInt(5, entity.getEmployee_id());
            preparedStatement.setInt(6, entity.getOrder_Status_id());
            preparedStatement.setInt(7, entity.getOrder_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Order entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, entity.getCustomer_id());
            preparedStatement.setDate(2, Date.valueOf(entity.getOrder_date()));
            preparedStatement.setDouble(3, entity.getTotal_price());
            preparedStatement.setInt(4, entity.getShipping_address_id());
            preparedStatement.setInt(5, entity.getEmployee_id());
            preparedStatement.setInt(6, entity.getOrder_Status_id());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if(result.next()){
                entity.setOrder_id(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Order entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getOrder_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
