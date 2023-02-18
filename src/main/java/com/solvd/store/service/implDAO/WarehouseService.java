package com.solvd.store.service.implDAO;

import com.solvd.store.dao.IWarehouseDAO;
import com.solvd.store.dao.mySQL.WarehouseDAO;
import com.solvd.store.models.Warehouse;
import com.solvd.store.service.IWarehouseService;

public class WarehouseService implements IWarehouseService {
    private final IWarehouseDAO warehouseDAO;

    public WarehouseService() {
        this.warehouseDAO = new WarehouseDAO();
    }

    @Override
    public Warehouse getEntityById(int id) {
        return null;
    }

    @Override
    public void update(Warehouse entity) {

    }

    @Override
    public void create(Warehouse entity) {

    }

    @Override
    public void delete(Warehouse entity) {

    }
}
