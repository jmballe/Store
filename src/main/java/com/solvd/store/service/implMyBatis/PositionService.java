package com.solvd.store.service.implMyBatis;

import com.solvd.store.dao.IPositionDAO;
import com.solvd.store.models.Position;
import com.solvd.store.service.IPositionService;
import com.solvd.store.utils.MyBatisDaoFactory;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class PositionService implements IPositionService {
    private static final SqlSessionFactory SESSION_FACTORY = MyBatisDaoFactory.getSqlSessionFactory();

    @Override
    public Position getEntityById(int id) {
        Position position;
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IPositionDAO positionDAO = sqlSession.getMapper(IPositionDAO.class);
            position = positionDAO.getEntityById(id);
            sqlSession.commit();
        }
        return position;
    }

    @Override
    public void update(Position entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IPositionDAO positionDAO = sqlSession.getMapper(IPositionDAO.class);
            positionDAO.update(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void create(Position entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IPositionDAO positionDAO = sqlSession.getMapper(IPositionDAO.class);
            positionDAO.create(entity);
            sqlSession.commit();
        }
    }

    @Override
    public void delete(Position entity) {
        try(SqlSession sqlSession = SESSION_FACTORY.openSession()) {
            IPositionDAO positionDAO = sqlSession.getMapper(IPositionDAO.class);
            positionDAO.delete(entity);
            sqlSession.commit();
        }
    }
}
