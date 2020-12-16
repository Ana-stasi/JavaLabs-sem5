package model.dao;

import model.entity.Category;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends BaseDAO<Integer, Category> {
     static final String findAllCategory ="select * from category";
    CategoryDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery(findAllCategory)) {
            while (resultSet.next()) {
                categories.add(new Category(
                        resultSet.getInt("category_id"),
                        resultSet.getString("category_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return categories;
    }

    @Override
    public List<Category> findAll(Integer parameter) {
        return null;
    }

    @Override
    public Category findEntityById(Integer id) {
        return null;
    }

    @Override
    public Category findEntityByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }

    @Override
    public boolean deleteEntity(Category entity) {
        return false;
    }

    @Override
    public void create(Category entity){

    }

    @Override
    public void update(Category entity) {
    }
}
