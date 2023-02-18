package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.ICustomerDAO;
import com.solvd.store.models.Customer;
import com.solvd.store.service.ICustomerService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CustomerService implements ICustomerService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Customer getEntityById(int id) {
        Customer customer;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customer = customerDAO.getEntityById(id);
        }
        return customer;
    }

    @Override
    public void update(Customer entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Customer entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.create(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Customer entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ICustomerDAO customerDAO = sqlSession.getMapper(ICustomerDAO.class);
            customerDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
