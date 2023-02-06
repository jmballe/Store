package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IEmployeeDAO;
import com.solvd.store.models.Employee;

public class EmployeeDAO extends MySQLDAO implements IEmployeeDAO {
    @Override
    public Employee getEntityById(int id) {
        return null;
    }

    @Override
    public Boolean update(Employee entity) {
        return null;
    }

    @Override
    public Employee create(Employee entity) {
        return null;
    }

    @Override
    public Boolean delete(Employee entity) {
        return null;
    }
}
