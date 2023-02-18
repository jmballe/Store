package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.IOrder_itemDAO;
import com.solvd.store.models.Order_item;
import com.solvd.store.service.IOrder_itemService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

public class Order_itemService implements IOrder_itemService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Order_item getEntityById(int order_id, int product_id) {
        Order_item orderItem;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrder_itemDAO order_itemDAO = sqlSession.getMapper(IOrder_itemDAO.class);
            orderItem = order_itemDAO.getEntityById(order_id,product_id);
        }
        return orderItem;
    }

    @Override
    public void update(Order_item entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrder_itemDAO order_itemDAO = sqlSession.getMapper(IOrder_itemDAO.class);
            order_itemDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Order_item entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrder_itemDAO order_itemDAO = sqlSession.getMapper(IOrder_itemDAO.class);
            order_itemDAO.create(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Order_item entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrder_itemDAO order_itemDAO = sqlSession.getMapper(IOrder_itemDAO.class);
            order_itemDAO.delete(entity);
            sqlSession.commit();
        }
    }

    @Override
    public List<Order_item> getAllEntitiesByOrderId(int order_id) {
        List<Order_item> productsInOrder;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IOrder_itemDAO order_itemDAO = sqlSession.getMapper(IOrder_itemDAO.class);
            productsInOrder = order_itemDAO.getAllEntitiesByOrderId(order_id);
        }
        return productsInOrder;
    }
}
