package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.IShipping_addressDAO;
import com.solvd.store.models.Shipping_address;
import com.solvd.store.service.IShipping_addressService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Shipping_AddressService implements IShipping_addressService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Shipping_address getEntityById(int id) {
        Shipping_address shipping_address;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IShipping_addressDAO shipping_addressDAO = sqlSession.getMapper(IShipping_addressDAO.class);
            shipping_address = shipping_addressDAO.getEntityById(id);
        }
        return shipping_address;
    }

    @Override
    public void update(Shipping_address entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IShipping_addressDAO shipping_addressDAO = sqlSession.getMapper(IShipping_addressDAO.class);
            shipping_addressDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Shipping_address entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IShipping_addressDAO shipping_addressDAO = sqlSession.getMapper(IShipping_addressDAO.class);
            shipping_addressDAO.create(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Shipping_address entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IShipping_addressDAO shipping_addressDAO = sqlSession.getMapper(IShipping_addressDAO.class);
            shipping_addressDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
