package com.solvd.store.service.implDAO;

import com.solvd.store.dao.ISupplierDAO;
import com.solvd.store.dao.mySQL.SupplierDAO;
import com.solvd.store.models.Supplier;
import com.solvd.store.service.ISupplierService;

public class SupplierService implements ISupplierService {

    private final ISupplierDAO supplierDAO;
    public SupplierService() {
        supplierDAO = new SupplierDAO();
    }

    @Override
    public Supplier getEntityById(int id) {
        return null;
    }

    @Override
    public void update(Supplier entity) {

    }

    @Override
    public void create(Supplier entity) {

    }

    @Override
    public void delete(Supplier entity) {

    }
}
