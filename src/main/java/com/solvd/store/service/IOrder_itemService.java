package com.solvd.store.service;

import com.solvd.store.models.Order_item;

import java.util.List;

public interface IOrder_itemService {
    public Order_item getEntityById(int order_id, int product_id);
    public void update(Order_item entity);
    public void create(Order_item entity);
    public void delete(Order_item entity);
    List<Order_item> getAllEntitiesByOrderId(int order_id);

}
