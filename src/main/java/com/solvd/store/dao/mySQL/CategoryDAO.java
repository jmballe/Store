package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.ICategoryDAO;
import com.solvd.store.models.Category;
import com.solvd.store.utils.ConnectionPool;

import java.io.IOException;
import java.sql.*;

public class CategoryDAO extends MySQLDAO implements ICategoryDAO {

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    public CategoryDAO() throws IOException{}

    private final static String INSERT = "INSERT INTO category(category_id, name, description) VALUES(?, ?, ?)";

    private final static String UPDATE = "UPDATE category SET name = ?, description = ? WHERE category_id = ?";

    private final static String DELETE = "DELETE FROM category WHERE idCategories = ?";

    private final static String GETALL = "SELECT category_id, name, description FROM category";

    private final static String GETBYID = "SELECT category_id, name, description FROM category WHERE category_id = ?";

    @Override
    public Category getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GETBYID, Statement.RETURN_GENERATED_KEYS)){
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){

            }
        } catch (SQLException e){

        } finally {
            connectionPool.releaseConnection(connection);
        }
        return null;
    }

    @Override
    public Boolean update(Category entity) {
        return null;
    }

    @Override
    public Category create(Category entity) {
        return null;
    }

    @Override
    public Boolean delete(Category entity) {
        return null;
    }
}
