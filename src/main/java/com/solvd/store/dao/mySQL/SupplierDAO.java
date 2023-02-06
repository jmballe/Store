package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.ISupplierDAO;
import com.solvd.store.models.Supplier;

import java.util.function.IntSupplier;

public class SupplierDAO extends MySQLDAO implements ISupplierDAO {
    @Override
    public Supplier getEntityById(int id) {
        return null;
    }

    @Override
    public Boolean update(Supplier entity) {
        return null;
    }

    @Override
    public Supplier create(Supplier entity) {
        return null;
    }

    @Override
    public Boolean delete(Supplier entity) {
        return null;
    }
}
