package com.solvd.store.service.implementation;

import com.solvd.store.dao.IProductDAO;
import com.solvd.store.dao.mySQL.ProductDAO;
import com.solvd.store.models.Product;
import com.solvd.store.service.IProductService;

public class ProductService implements IProductService {

    private final IProductDAO productDAO;
    public ProductService() {
        productDAO = new ProductDAO();
    }

    @Override
    public Product getEntityById(int id) {
        return null;
    }

    @Override
    public void update(Product entity) {

    }

    @Override
    public void create(Product entity) {

    }

    @Override
    public void delete(Product entity) {

    }
}
