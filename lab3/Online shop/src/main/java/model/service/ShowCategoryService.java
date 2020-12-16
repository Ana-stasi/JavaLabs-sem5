package model.service;

import model.dao.BaseDAO;
import model.entity.Category;

import java.sql.SQLException;
import java.util.List;

public class ShowCategoryService extends BaseService<List<Category>,String> {
    @Override
    public List<Category> performAction(String entity) throws SQLException {
        List<Category> categories = null;
            BaseDAO<Integer,Category> dao = daoFactory.createDAO("category");
            categories = dao.findAll();
            dao.close();


        return categories;
    }
}
