package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.IInventoryDAO;
import com.solvd.store.models.Inventory;
import com.solvd.store.service.IInventoryService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class InventoryService implements IInventoryService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();
    @Override
    public Inventory getEntityById(int id) {
        Inventory inventory;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventory = inventoryDAO.getEntityById(id);
        }
        return inventory;
    }

    @Override
    public void update(Inventory entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventoryDAO.update(entity);
            sqlSession.commit();
        }

    }

    @Override
    public void create(Inventory entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventoryDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Inventory entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IInventoryDAO inventoryDAO = sqlSession.getMapper(IInventoryDAO.class);
            inventoryDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
