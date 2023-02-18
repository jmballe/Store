package com.solvd.store.service.implDAO;

import com.solvd.store.dao.IOrder_statusDAO;
import com.solvd.store.dao.mySQL.Order_statusDAO;
import com.solvd.store.models.Order_status;
import com.solvd.store.service.IOrder_StatusService;

public class Order_statusService implements IOrder_StatusService {

    private final IOrder_statusDAO orderStatusDAO;
    public Order_statusService() {
        orderStatusDAO = new Order_statusDAO();
    }

    @Override
    public Order_status getEntityById(int id) {
        return null;
    }

    @Override
    public void update(Order_status entity) {

    }

    @Override
    public void create(Order_status entity) {

    }

    @Override
    public void delete(Order_status entity) {

    }
}
