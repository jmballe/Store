package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IOrder_itemDAO;
import com.solvd.store.models.Order_item;
import com.solvd.store.utils.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Order_itemDAO extends MySQLDAO implements IOrder_itemDAO {

    private final static String INSERT = "INSERT INTO order_item(order_id, product_id, quantity) VALUES(?, ?, ?)";
    private final static String UPDATE = "UPDATE order_item SET order_id = ?,product_id = ?,quantity = ? WHERE order_id = ? AND product_id = ?";
    private final static String DELETE = "DELETE FROM order_item WHERE order_id = ? AND product_id = ?";
    private final static String GETBYID = "SELECT order_id, product_id, quantity FROM order_item WHERE order_id = ? AND product_id = ?";
    private final static String GETALLBYORDERID = "SELECT order_id, product_id, quantity FROM order_item WHERE order_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    public Order_itemDAO(){}
    @Override
    public Order_item getEntityById(int id,int id2) {
        Connection connection = connectionPool.getConnection();
        Order_item orderItem = new Order_item();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GETBYID)){
            preparedStatement.setInt(1,id);
            preparedStatement.setInt(2, id2);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                orderItem.setOrder_id(result.getInt(1));
                orderItem.setProduct_id(result.getInt(2));
                orderItem.setQuantity(result.getInt(3));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return orderItem;
    }

    @Override
    public void update(Order_item entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1,entity.getOrder_id());
            preparedStatement.setInt(2, entity.getProduct_id());
            preparedStatement.setInt(3,entity.getQuantity());
            preparedStatement.setInt(4,entity.getOrder_id());
            preparedStatement.setInt(5, entity.getProduct_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Order_item entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1,entity.getOrder_id());
            preparedStatement.setInt(2, entity.getProduct_id());
            preparedStatement.setInt(3,entity.getQuantity());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Order_item entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getOrder_id());
            preparedStatement.setInt(2, entity.getProduct_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public List<Order_item> getAllEntitiesByOrderId(int order_id) {
        Connection connection = connectionPool.getConnection();
        List<Order_item> allWithOrderId = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GETALLBYORDERID)){
            preparedStatement.setInt(1,order_id);
            ResultSet result = preparedStatement.executeQuery();
            while(result.next()){
                Order_item orderItem = new Order_item();
                orderItem.setOrder_id(result.getInt(1));
                orderItem.setProduct_id(result.getInt(2));
                orderItem.setQuantity(result.getInt(3));
                allWithOrderId.add(orderItem);
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return allWithOrderId;
    }
}
