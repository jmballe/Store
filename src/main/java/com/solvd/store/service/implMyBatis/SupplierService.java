package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.ISupplierDAO;
import com.solvd.store.models.Supplier;
import com.solvd.store.service.ISupplierService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class SupplierService implements ISupplierService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Supplier getEntityById(int id) {
        Supplier supplier;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ISupplierDAO supplierDAO = sqlSession.getMapper(ISupplierDAO.class);
            supplier = supplierDAO.getEntityById(id);
        }
        return supplier;
    }

    @Override
    public void update(Supplier entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ISupplierDAO supplierDAO = sqlSession.getMapper(ISupplierDAO.class);
            supplierDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Supplier entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ISupplierDAO supplierDAO = sqlSession.getMapper(ISupplierDAO.class);
            supplierDAO.create(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Supplier entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ISupplierDAO supplierDAO = sqlSession.getMapper(ISupplierDAO.class);
            supplierDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
