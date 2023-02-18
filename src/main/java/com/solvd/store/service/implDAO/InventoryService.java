package com.solvd.store.service.implDAO;

import com.solvd.store.dao.IInventoryDAO;
import com.solvd.store.dao.mySQL.InventoryDAO;
import com.solvd.store.models.Inventory;
import com.solvd.store.service.IInventoryService;

public class InventoryService implements IInventoryService {

    private final IInventoryDAO inventoryDAO;

    public InventoryService() {
        inventoryDAO = new InventoryDAO();
    }

    @Override
    public Inventory getEntityById(int id) {
        return inventoryDAO.getEntityById(id);
    }

    @Override
    public void update(Inventory entity) {
        inventoryDAO.update(entity);
    }

    @Override
    public void create(Inventory entity) {
        inventoryDAO.create(entity);
    }

    @Override
    public void delete(Inventory entity) {
        inventoryDAO.delete(entity);
    }
}
