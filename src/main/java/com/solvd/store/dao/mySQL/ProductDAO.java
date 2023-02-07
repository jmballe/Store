package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IProductDAO;
import com.solvd.store.models.Product;
import com.solvd.store.utils.ConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductDAO extends MySQLDAO implements IProductDAO {

    private final static String INSERT = "INSERT INTO product (name, price, description, category_id, supplier_id) VALUES(?, ?, ? ,? ,?)";
    private final static String UPDATE = "UPDATE product SET name = ?, price = ?, description = ?, category_id = ?, supplier_id = ? WHERE product_id = ?";
    private final static String DELETE = "DELETE FROM product WHERE product_id = ?";
    private final static String GETBYID = "SELECT product_id, name, price, description, category_id, supplier_id FROM product WHERE product_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);


    @Override
    public Product getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Product product = new Product();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GETBYID)){
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                product.setProduct_id(result.getInt(1));
                product.setName(result.getString(2));
                product.setPrice(result.getDouble(3));
                product.setDescription(result.getString(4));
                product.setCategory_id(result.getInt(5));
                product.setSupplier_id(result.getInt(6));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return product;
    }

    @Override
    public void update(Product entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setDouble(2, entity.getPrice());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setInt(4, entity.getCategory_id());
            preparedStatement.setInt(5, entity.getSupplier_id());
            preparedStatement.setInt(6, entity.getProduct_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Product entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT)) {
            preparedStatement.setString(1, entity.getName());
            preparedStatement.setDouble(2, entity.getPrice());
            preparedStatement.setString(3, entity.getDescription());
            preparedStatement.setInt(4, entity.getCategory_id());
            preparedStatement.setInt(5, entity.getSupplier_id());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if(result.next()){
                entity.setProduct_id(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Product entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getProduct_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
