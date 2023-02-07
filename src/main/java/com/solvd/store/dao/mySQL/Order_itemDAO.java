package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IOrder_itemDAO;
import com.solvd.store.models.Order_item;
import com.solvd.store.utils.ConnectionPool;

public class Order_itemDAO extends MySQLDAO implements IOrder_itemDAO {

    private final static String INSERT = "INSERT INTO order_item(order_id, product_id, quantity) VALUES(?, ?, ?)";
    private final static String UPDATE = "UPDATE order_item SET order_id = ?,product_id = ?,quantity = ? WHERE status_id = ?";
    private final static String DELETE = "DELETE FROM order_item WHERE status_id = ?";
    private final static String GETBYID = "SELECT order_id, product_id, quantity FROM order_item WHERE status_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);
    @Override
    public Order_item getEntityById(int id) {
        return null;
    }

    @Override
    public void update(Order_item entity) {

    }

    @Override
    public void create(Order_item entity) {

    }

    @Override
    public void delete(Order_item entity) {

    }
}
