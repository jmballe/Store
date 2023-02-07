package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.ISupplierDAO;
import com.solvd.store.models.Supplier;
import com.solvd.store.utils.ConnectionPool;

import java.io.IOException;
import java.sql.*;

public class SupplierDAO extends MySQLDAO implements ISupplierDAO {

    private final static String INSERT = "INSERT INTO supplier (name, address, city, state, zipcode) VALUES(?, ?, ? ,? ,?)";
    private final static String UPDATE = "UPDATE supplier SET name = ?, address = ?, city = ?, state = ?, zipcode = ? WHERE supplier_id = ?";
    private final static String DELETE = "DELETE FROM supplier WHERE supplier_id = ?";
    private final static String GETBYID = "SELECT supplier_id, name, address, city, state, zipcode FROM supplier WHERE supplier_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    public SupplierDAO() {
    }

    @Override
    public Supplier getEntityById(int id) {
        return null;
    }

    @Override
    public void update(Supplier entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getAddress());
            preparedStatement.setString(3, entity.getCity());
            preparedStatement.setString(4, entity.getState());
            preparedStatement.setString(5, entity.getZipcode());
            preparedStatement.setInt(6, entity.getSupplier_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Supplier entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getAddress());
            preparedStatement.setString(3, entity.getCity());
            preparedStatement.setString(4, entity.getState());
            preparedStatement.setString(5, entity.getZipcode());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if(result.next()){
                entity.setSupplier_id(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Supplier entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getSupplier_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
