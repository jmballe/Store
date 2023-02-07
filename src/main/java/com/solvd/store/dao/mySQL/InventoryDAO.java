package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IInventoryDAO;
import com.solvd.store.models.Employee;
import com.solvd.store.models.Inventory;
import com.solvd.store.utils.ConnectionPool;

import java.sql.*;

public class InventoryDAO extends MySQLDAO implements IInventoryDAO {

    private final static String INSERT = "INSERT INTO inventory (product_id,quantity,warehouse_id) VALUES(?, ?, ?)";
    private final static String UPDATE = "UPDATE inventory SET product_id = ?,quantity = ?,warehouse_id = ? WHERE inventory_id = ?";
    private final static String DELETE = "DELETE FROM inventory WHERE inventory_id = ?";
    private final static String GETBYID = "SELECT inventory_id, product_id,quantity,warehouse_id FROM inventory WHERE inventory_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);
    @Override
    public Inventory getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Inventory inventory = new Inventory();
        try (PreparedStatement preparedStatement = connection.prepareStatement(GETBYID, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, id);
            ResultSet result = preparedStatement.executeQuery();
            if (result.next()) {
                inventory.setInventory_id(result.getInt(1));
                inventory.setProduct_id(result.getInt(2));
                inventory.setQuantity(result.getInt(3));
                inventory.setWarehouse_id(result.getInt(4));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return inventory;
    }

    @Override
    public void update(Inventory entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setInt(1, entity.getProduct_id());
            preparedStatement.setInt(2, entity.getQuantity());
            preparedStatement.setInt(3, entity.getWarehouse_id());
            preparedStatement.setInt(4, entity.getInventory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Inventory entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(INSERT,Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, entity.getProduct_id());
            preparedStatement.setInt(2, entity.getQuantity());
            preparedStatement.setInt(3, entity.getWarehouse_id());
            preparedStatement.setInt(4, entity.getInventory_id());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if(result.next()){
                entity.setInventory_id(result.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Inventory entity) {
        Connection connection = connectionPool.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1, entity.getInventory_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
