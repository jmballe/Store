package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IProductDAO;
import com.solvd.store.models.Product;

public class ProductDAO extends MySQLDAO implements IProductDAO {
    @Override
    public Product getEntityById(int id) {
        return null;
    }

    @Override
    public Boolean update(Product entity) {
        return null;
    }

    @Override
    public Product create(Product entity) {
        return null;
    }

    @Override
    public Boolean delete(Product entity) {
        return null;
    }
}
