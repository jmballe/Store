package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.ICategoryDAO;
import com.solvd.store.models.Category;
import com.solvd.store.service.ICategory;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class CategoryService implements ICategory {

    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();
    @Override
    public Category getEntityById(int id) {
        Category category;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            category = categoryDAO.getEntityById(id);
        }
        return category;
    }

    @Override
    public void update(Category entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            categoryDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Category entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            categoryDAO.create(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Category entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()){
            ICategoryDAO categoryDAO = sqlSession.getMapper(ICategoryDAO.class);
            categoryDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
