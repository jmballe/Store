package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.ICustomerDAO;
import com.solvd.store.models.Customer;
import com.solvd.store.utils.ConnectionPool;
import java.sql.*;

public class CustomerDAO extends MySQLDAO implements ICustomerDAO {

    private final static String INSERT = "INSERT INTO customer (name, email, address) VALUES(?, ?, ?)";

    private final static String UPDATE = "UPDATE customer SET name = ?, email = ?, address = ? WHERE customer_id = ?";

    private final static String DELETE = "DELETE FROM customer WHERE customer_id = ?";

    private final static String GETBYID = "SELECT customer_id, name, email, address FROM customer WHERE customer_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    public CustomerDAO(){
    }

    @Override
    public Customer getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Customer customer = new Customer();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GETBYID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                customer.setCustomer_id(result.getInt(1));
                customer.setName(result.getString(2));
                customer.setEmail(result.getString(3));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return customer;
    }

    @Override
    public void update(Customer entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setInt(4, entity.getCustomer_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Customer entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if (result.next()) {
                entity.setCustomer_id(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Customer entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getCustomer_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
