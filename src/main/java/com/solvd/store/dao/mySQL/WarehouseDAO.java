package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IWarehouseDAO;
import com.solvd.store.models.Warehouse;
import com.solvd.store.utils.ConnectionPool;

import java.sql.*;

public class WarehouseDAO extends MySQLDAO implements IWarehouseDAO {

    private final static String INSERT = "INSERT INTO warehouse (name, address, city, state, zipcode, phone) VALUES(?, ?, ? ,? ,?,?)";
    private final static String UPDATE = "UPDATE warehouse SET name = ?, address = ?, city = ?, state = ?, zipcode = ?, phone = ? WHERE warehouse_id = ?";
    private final static String DELETE = "DELETE FROM warehouse WHERE warehouse_id = ?";
    private final static String GETBYID = "SELECT warehouse_id, name, address, city, state, zipcode, phone FROM warehouse WHERE warehouse_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);
    @Override
    public Warehouse getEntityById(int id) {
        return null;
    }

    @Override
    public void update(Warehouse entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getAddress());
            preparedStatement.setString(3, entity.getCity());
            preparedStatement.setString(4, entity.getState());
            preparedStatement.setString(5, entity.getZipcode());
            preparedStatement.setString(6, entity.getPhone());
            preparedStatement.setInt(7, entity.getWarehouse_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Warehouse entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getAddress());
            preparedStatement.setString(3, entity.getCity());
            preparedStatement.setString(4, entity.getState());
            preparedStatement.setString(5, entity.getZipcode());
            preparedStatement.setString(6, entity.getPhone());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if(result.next()){
                entity.setWarehouse_id(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Warehouse entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getWarehouse_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
