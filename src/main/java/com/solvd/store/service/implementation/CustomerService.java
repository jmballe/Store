package com.solvd.store.service.implementation;

import com.solvd.store.dao.ICustomerDAO;
import com.solvd.store.dao.mySQL.CustomerDAO;
import com.solvd.store.models.Customer;
import com.solvd.store.service.ICustomerService;

public class CustomerService implements ICustomerService {

    private final ICustomerDAO customerDAO;

    CustomerService(){
        customerDAO = new CustomerDAO();
    }
    @Override
    public Customer getEntityById(int id) {
        return customerDAO.getEntityById(id);
    }

    @Override
    public void update(Customer entity) {
        customerDAO.update(entity);
    }

    @Override
    public void create(Customer entity) {
        customerDAO.create(entity);
    }

    @Override
    public void delete(Customer entity) {
        customerDAO.delete(entity);
    }
}
