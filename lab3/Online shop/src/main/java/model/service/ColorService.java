package lab3.model.service;

import lab3.model.dao.AbstractDAO;
import lab3.model.entity.Color;
import lab3.model.service.exceptions.EmptyCatalogueException;

import java.sql.SQLException;
import java.util.List;

public class ColorService extends BaseService {

    public List<Color> getColors() throws EmptyCatalogueException, SQLException {

        AbstractDAO<Integer, Color> dao = daoFactory.createDAO("color");
        List<Color> colors = dao.findAll();
        dao.closeConnection();
        if (colors != null)
            return colors;
        else throw new EmptyCatalogueException();
    }

    public Color findColor(int id) throws EmptyCatalogueException,SQLException {
        AbstractDAO<Integer, Color> dao = daoFactory.createDAO("color");
        Color color = dao.findEntityById(id);
        if(color!=null)
            return  color;
        else throw new EmptyCatalogueException("No сolor with such №");
    }
}
