package lab3.model.service;

import lab3.model.dao.AbstractDAO;
import lab3.model.entity.Category;
import lab3.model.service.exceptions.EmptyCatalogueException;

import java.sql.SQLException;
import java.util.List;

public class CategoryService extends BaseService {

    public List<Category> getCategories() throws SQLException {
            AbstractDAO<Integer,Category> dao = daoFactory.createDAO("category");
            List<Category> categories = dao.findAll();
            dao.closeConnection();
        if (categories != null)
            return categories;
        else throw new EmptyCatalogueException();
    }
    public Category findCategory(int id) throws EmptyCatalogueException,SQLException {
        AbstractDAO<Integer, Category> dao = daoFactory.createDAO("category");
        Category category = dao.findEntityById(id);
        if(category!=null)
            return  category;
        else throw new EmptyCatalogueException("No сategory with such №");
    }
}
