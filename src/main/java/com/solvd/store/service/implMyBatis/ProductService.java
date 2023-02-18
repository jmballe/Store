package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.IProductDAO;
import com.solvd.store.models.Product;
import com.solvd.store.service.IProductService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class ProductService implements IProductService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Product getEntityById(int id) {
        Product product;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IProductDAO productDAO = sqlSession.getMapper(IProductDAO.class);
            product = productDAO.getEntityById(id);
            sqlSession.commit();
        }
        return product;
    }

    @Override
    public void update(Product entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IProductDAO productDAO = sqlSession.getMapper(IProductDAO.class);
            productDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Product entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IProductDAO productDAO = sqlSession.getMapper(IProductDAO.class);
            productDAO.create(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Product entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IProductDAO productDAO = sqlSession.getMapper(IProductDAO.class);
            productDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
