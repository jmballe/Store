package com.solvd.store.service.implDAO;

import com.solvd.store.dao.IPositionDAO;
import com.solvd.store.dao.mySQL.PositionDAO;
import com.solvd.store.models.Position;
import com.solvd.store.service.IPositionService;

public class PositionService implements IPositionService {

    private final IPositionDAO positionDAO;
    public PositionService() {
        positionDAO = new PositionDAO();
    }

    @Override
    public Position getEntityById(int id) {
        return null;
    }

    @Override
    public void update(Position entity) {

    }

    @Override
    public void create(Position entity) {

    }

    @Override
    public void delete(Position entity) {

    }
}
