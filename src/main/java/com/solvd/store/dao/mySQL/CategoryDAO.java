package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.ICategoryDAO;
import com.solvd.store.models.Category;
import com.solvd.store.utils.ConnectionPool;
import java.sql.*;

public class CategoryDAO extends MySQLDAO implements ICategoryDAO {

    private final static String INSERT = "INSERT INTO category(name, description) VALUES(?, ?)";
    private final static String UPDATE = "UPDATE category SET name = ?, description = ? WHERE category_id = ?";
    private final static String DELETE = "DELETE FROM category WHERE category_id = ?";
    private final static String GETBYID = "SELECT category_id, name, description FROM category WHERE category_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    public CategoryDAO(){};



    @Override
    public Category getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Category category = new Category();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GETBYID)){
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                category.setCategory_id(result.getInt(1));
                category.setName(result.getString(2));
                category.setDescription(result.getString(3));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return category;
    }

    @Override
    public void update(Category entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1,entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3,entity.getCategory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Category entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if(result.next()){
                entity.setCategory_id(result.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Category entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1,entity.getCategory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
