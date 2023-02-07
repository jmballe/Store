package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IOrder_statusDAO;
import com.solvd.store.models.Order_status;
import com.solvd.store.utils.ConnectionPool;

import java.sql.*;

public class Order_statusDAO extends MySQLDAO implements IOrder_statusDAO {

    private final static String INSERT = "INSERT INTO order_status(status_name) VALUES(?)";
    private final static String UPDATE = "UPDATE order_status SET status_name = ? WHERE status_id = ?";
    private final static String DELETE = "DELETE FROM order_status WHERE status_id = ?";
    private final static String GETBYID = "SELECT status_id, status_name FROM order_status WHERE status_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    @Override
    public Order_status getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Order_status status = new Order_status();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GETBYID)){
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                status.setStatus_id(result.getInt(1));
                status.setName(result.getString(2));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return status;
    }

    @Override
    public void update(Order_status entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1,entity.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Order_status entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,entity.getName());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if(result.next()){
                entity.setStatus_id(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Order_status entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1,entity.getStatus_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
