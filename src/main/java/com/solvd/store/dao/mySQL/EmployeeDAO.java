package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IEmployeeDAO;
import com.solvd.store.models.Customer;
import com.solvd.store.models.Employee;
import com.solvd.store.utils.ConnectionPool;

import java.sql.*;

public class EmployeeDAO extends MySQLDAO implements IEmployeeDAO {

    private final static String INSERT = "INSERT INTO employee (name, email, address, position_id) VALUES(?, ?, ? ,?)";
    private final static String UPDATE = "UPDATE employee SET name = ?,email = ?, address = ?,  position_id =? WHERE employee_id = ?";
    private final static String DELETE = "DELETE FROM employee WHERE employee_id = ?";
    private final static String GETBYID = "SELECT employee_id, name, email, address, position_id FROM employee WHERE employee_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);
    @Override
    public Employee getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Employee employee = new Employee();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GETBYID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                employee.setEmployee_id(result.getInt(1));
                employee.setName(result.getString(2));
                employee.setEmail(result.getString(3));
                employee.setAddress(result.getString(4));
                employee.setPosition_id(result.getInt(5));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return employee;
    }

    @Override
    public void update(Employee entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setInt(4, entity.getPosition_id());
            preparedStatement.setInt(5,entity.getEmployee_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Employee entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setString(2, entity.getEmail());
            preparedStatement.setString(3, entity.getAddress());
            preparedStatement.setInt(4, entity.getPosition_id());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if(result.next()){
                entity.setEmployee_id(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Employee entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getEmployee_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
