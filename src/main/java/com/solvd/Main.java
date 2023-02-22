package com.solvd;

import com.solvd.store.models.Category;
import com.solvd.store.service.implMyBatis.CategoryService;

import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        CategoryService catService = new CategoryService();

        Category bagsCat = new Category("Bags","All king of bags.");
//
        catService.create(bagsCat);
//
        Category cat = catService.getEntityById(bagsCat.getCategory_id());
//
        catService.delete(bagsCat);
//
        System.out.println(cat.getCategory_id() + " | " + cat.getName());

//        Order_itemService orderItemService = new Order_itemService();
//
//        Order_item orderItem = new Order_item(4,2,3);

//        orderItemService.create(orderItem);

//        List<Order_item> byOrder_id = orderItemService.getAllEntitiesByOrderId(4);
//
//        System.out.println(byOrder_id);
    }
}