package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IInventoryDAO;
import com.solvd.store.models.Inventory;

public class InventoryDAO extends MySQLDAO implements IInventoryDAO {
    @Override
    public Inventory getEntityById(int id) {
        return null;
    }

    @Override
    public Boolean update(Inventory entity) {
        return null;
    }

    @Override
    public Inventory create(Inventory entity) {
        return null;
    }

    @Override
    public Boolean delete(Inventory entity) {
        return null;
    }
}
