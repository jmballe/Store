package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.IOrder_statusDAO;
import com.solvd.store.models.Order_status;
import com.solvd.store.service.IOrder_StatusService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class Order_statusService implements IOrder_StatusService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Order_status getEntityById(int id) {
        Order_status orderStatus;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrder_statusDAO order_statusDAO = sqlSession.getMapper(IOrder_statusDAO.class);
            orderStatus = order_statusDAO.getEntityById(id);
        }
        return orderStatus;
    }

    @Override
    public void update(Order_status entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrder_statusDAO order_statusDAO = sqlSession.getMapper(IOrder_statusDAO.class);
            order_statusDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Order_status entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrder_statusDAO order_statusDAO = sqlSession.getMapper(IOrder_statusDAO.class);
            order_statusDAO.create(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Order_status entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrder_statusDAO order_statusDAO = sqlSession.getMapper(IOrder_statusDAO.class);
            order_statusDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
