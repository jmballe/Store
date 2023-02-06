package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IOrderDAO;
import com.solvd.store.models.Order;

public class OrderDAO extends MySQLDAO implements IOrderDAO {
    @Override
    public Order getEntityById(int id) {
        return null;
    }

    @Override
    public Boolean update(Order entity) {
        return null;
    }

    @Override
    public Order create(Order entity) {
        return null;
    }

    @Override
    public Boolean delete(Order entity) {
        return null;
    }
}
