package com.solvd.store.service.implementation;

import com.solvd.store.dao.IShipping_addressDAO;
import com.solvd.store.dao.mySQL.Shipping_addressDAO;
import com.solvd.store.models.Shipping_address;
import com.solvd.store.service.IShipping_addressService;

public class Shipping_addressService implements IShipping_addressService {
    private final IShipping_addressDAO shippingAddressDAO;
    public Shipping_addressService() {
        shippingAddressDAO = new Shipping_addressDAO();
    }

    @Override
    public Shipping_address getEntityById(int id) {
        return null;
    }

    @Override
    public void update(Shipping_address entity) {

    }

    @Override
    public void create(Shipping_address entity) {

    }

    @Override
    public void delete(Shipping_address entity) {

    }
}
