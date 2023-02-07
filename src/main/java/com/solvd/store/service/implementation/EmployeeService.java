package com.solvd.store.service.implementation;

import com.solvd.store.dao.IEmployeeDAO;
import com.solvd.store.dao.mySQL.EmployeeDAO;
import com.solvd.store.models.Employee;
import com.solvd.store.service.IEmployeeService;

public class EmployeeService implements IEmployeeService {
    private final IEmployeeDAO employeeDAO;

    public EmployeeService(){
        employeeDAO = new EmployeeDAO();
    }

    @Override
    public Employee getEntityById(int id) {
        return employeeDAO.getEntityById(id);
    }

    @Override
    public void update(Employee entity) {
        employeeDAO.update(entity);
    }

    @Override
    public void create(Employee entity) {
        employeeDAO.create(entity);
    }

    @Override
    public void delete(Employee entity) {
        employeeDAO.delete(entity);
    }
}
