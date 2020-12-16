package model.service;

import model.dao.BaseDAO;
import model.entity.Color;

import java.sql.SQLException;
import java.util.List;

public class ShowColorService extends BaseService<List<Color>,String>{

    @Override
    public List<Color> performAction(String entity) throws SQLException {
        List<Color> colors = null;

            BaseDAO<Integer, Color> dao = daoFactory.createDAO("color");
            colors = dao.findAll();
            dao.close();


        return colors;
    }
}
