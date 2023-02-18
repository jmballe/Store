package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.IEmployeeDAO;
import com.solvd.store.models.Employee;
import com.solvd.store.service.IEmployeeService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class EmployeeService implements IEmployeeService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Employee getEntityById(int id) {
        Employee employee;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employee = employeeDAO.getEntityById(id);
        }
        return employee;
    }

    @Override
    public void update(Employee entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Employee entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.create(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Employee entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IEmployeeDAO employeeDAO = sqlSession.getMapper(IEmployeeDAO.class);
            employeeDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
