package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.IOrderDAO;
import com.solvd.store.models.Order;
import com.solvd.store.service.IOrderService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class OrderService implements IOrderService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Order getEntityById(int id) {
        Order order;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
            order = orderDAO.getEntityById(id);
        }
        return order;
    }

    @Override
    public void update(Order entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
            orderDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Order entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
            orderDAO.create(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Order entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrderDAO orderDAO = sqlSession.getMapper(IOrderDAO.class);
            orderDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
