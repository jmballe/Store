package com.solvd.store.service.implDAO;

import com.solvd.store.dao.IOrderDAO;
import com.solvd.store.dao.mySQL.OrderDAO;
import com.solvd.store.models.Order;
import com.solvd.store.service.IOrderService;

public class OrderService implements IOrderService {

    private final IOrderDAO orderDAO;
    public OrderService() {
        orderDAO = new OrderDAO();
    }

    @Override
    public Order getEntityById(int id) {
        return null;
    }

    @Override
    public void update(Order entity) {

    }

    @Override
    public void create(Order entity) {

    }

    @Override
    public void delete(Order entity) {

    }
}
