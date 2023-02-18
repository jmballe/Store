package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.IWarehouseDAO;
import com.solvd.store.dao.IWarehouseDAO;
import com.solvd.store.models.Warehouse;
import com.solvd.store.service.IWarehouseService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class WarehouseService implements IWarehouseService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Warehouse getEntityById(int id) {
        Warehouse warehouse;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IWarehouseDAO warehouseDAO = sqlSession.getMapper(IWarehouseDAO.class);
            warehouse = warehouseDAO.getEntityById(id);
        }
        return warehouse;
    }

    @Override
    public void update(Warehouse entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IWarehouseDAO warehouseDAO = sqlSession.getMapper(IWarehouseDAO.class);
            warehouseDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Warehouse entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IWarehouseDAO warehouseDAO = sqlSession.getMapper(IWarehouseDAO.class);
            warehouseDAO.delete(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Warehouse entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IWarehouseDAO warehouseDAO = sqlSession.getMapper(IWarehouseDAO.class);
            warehouseDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
