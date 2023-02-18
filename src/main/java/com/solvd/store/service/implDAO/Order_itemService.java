package com.solvd.store.service.implDAO;

import com.solvd.store.dao.IOrder_itemDAO;
import com.solvd.store.dao.mySQL.Order_itemDAO;
import com.solvd.store.models.Order_item;
import com.solvd.store.service.IOrder_itemService;

import java.util.List;

public class Order_itemService implements IOrder_itemService {

    private final IOrder_itemDAO orderItemDAO;

    public Order_itemService(){
        orderItemDAO = new Order_itemDAO();
    }
    @Override
    public Order_item getEntityById(int order_id, int product_id) {
        return orderItemDAO.getEntityById(order_id,product_id);
    }

    @Override
    public void update(Order_item entity) {
        orderItemDAO.update(entity);
    }

    @Override
    public void create(Order_item entity) {
        orderItemDAO.create(entity);
    }

    @Override
    public void delete(Order_item entity) {
        orderItemDAO.delete(entity);
    }

    @Override
    public List<Order_item> getAllEntitiesByOrderId(int order_id) {
        return orderItemDAO.getAllEntitiesByOrderId(order_id);
    }
}
