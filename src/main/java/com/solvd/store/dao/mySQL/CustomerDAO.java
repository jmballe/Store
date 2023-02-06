package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.ICustomerDAO;
import com.solvd.store.models.Customer;

public class CustomerDAO extends MySQLDAO implements ICustomerDAO {
    @Override
    public Customer getEntityById(int id) {
        return null;
    }

    @Override
    public Boolean update(Customer entity) {
        return null;
    }

    @Override
    public Customer create(Customer entity) {
        return null;
    }

    @Override
    public Boolean delete(Customer entity) {
        return null;
    }
}
