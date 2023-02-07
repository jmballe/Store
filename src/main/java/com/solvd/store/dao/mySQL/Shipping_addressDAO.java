package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IShipping_addressDAO;
import com.solvd.store.models.Shipping_address;
import com.solvd.store.utils.ConnectionPool;

import java.sql.*;

public class Shipping_addressDAO extends MySQLDAO implements IShipping_addressDAO {

    private final static String INSERT = "INSERT INTO shipping_address (name, address, city, state, zipcode, phone) VALUES(?, ?, ? ,? ,?,?)";
    private final static String UPDATE = "UPDATE shipping_address SET name = ?, address = ?, city = ?, state = ?, zipcode = ?, phone = ? WHERE shipping_address_id = ?";
    private final static String DELETE = "DELETE FROM shipping_address WHERE shipping_address_id = ?";
    private final static String GETBYID = "SELECT shipping_address_id, name, address, city, state, zipcode, phone FROM shipping_address WHERE shipping_address_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);
    @Override
    public Shipping_address getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Shipping_address shippingAddress = new Shipping_address();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GETBYID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                shippingAddress.setShipping_address_id(result.getInt(1));
                shippingAddress.setName(result.getString(2));
                shippingAddress.setAddress(result.getString(3));
                shippingAddress.setCity(result.getString(4));
                shippingAddress.setState(result.getString(5));
                shippingAddress.setZipcode(result.getString(6));
                shippingAddress.setPhone(result.getString(7));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return shippingAddress;
    }

    @Override
    public void update(Shipping_address entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getAddress());
            preparedStatement.setString(3, entity.getCity());
            preparedStatement.setString(4, entity.getState());
            preparedStatement.setString(5, entity.getZipcode());
            preparedStatement.setString(6, entity.getPhone());
            preparedStatement.setInt(7, entity.getShipping_address_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Shipping_address entity) {
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
                entity.setShipping_address_id(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Shipping_address entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getShipping_address_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
