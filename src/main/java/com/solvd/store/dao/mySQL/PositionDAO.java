package com.solvd.store.dao.mySQL;

import com.solvd.store.dao.IPositionDAO;
import com.solvd.store.models.Position;
import com.solvd.store.utils.ConnectionPool;

import java.sql.*;

public class PositionDAO extends MySQLDAO implements IPositionDAO {
    private final static String INSERT = "INSERT INTO position(name, description) VALUES(?, ?)";
    private final static String UPDATE = "UPDATE position SET name = ?, description = ? WHERE position_id = ?";
    private final static String DELETE = "DELETE FROM position WHERE position_id = ?";
    private final static String GETBYID = "SELECT position_id, name, description FROM position WHERE position_id = ?";

    private final ConnectionPool connectionPool = ConnectionPool.getInstance(5);

    public PositionDAO(){

    }
    @Override
    public Position getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Position position = new Position();
        try(PreparedStatement preparedStatement = connection.prepareStatement(GETBYID)){
            preparedStatement.setInt(1,id);
            ResultSet result = preparedStatement.executeQuery();
            if(result.next()){
                position.setPosition_id(result.getInt(1));
                position.setName(result.getString(2));
                position.setDescription(result.getString(3));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
        return position;
    }

    @Override
    public void update(Position entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(UPDATE)) {
            preparedStatement.setString(1,entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.setInt(3,entity.getPosition_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void create(Position entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setString(1,entity.getName());
            preparedStatement.setString(2, entity.getDescription());
            preparedStatement.executeUpdate();
            ResultSet result = preparedStatement.getGeneratedKeys();
            if(result.next()){
                entity.setPosition_id(result.getInt(1));
            }
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }

    @Override
    public void delete(Position entity) {
        Connection connection = connectionPool.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(DELETE)) {
            preparedStatement.setInt(1,entity.getPosition_id());
            preparedStatement.executeUpdate();
        } catch (SQLException e){
            e.printStackTrace();
        } finally {
            connectionPool.releaseConnection(connection);
        }
    }
}
