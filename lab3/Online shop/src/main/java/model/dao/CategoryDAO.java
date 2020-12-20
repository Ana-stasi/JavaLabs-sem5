package lab3.model.dao;

import lab3.model.entity.Category;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<Integer, Category> {
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
        String findCategoryById = "select * from category where category_id = ?";
        Category category = null;
        try (PreparedStatement ps = connection.prepareStatement(findCategoryById)) {
            ps.setInt(1, id);
            try(ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    category = new Category(
                            resultSet.getInt("category_id"),
                            resultSet.getString("category_name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return category;
    }

    @Override
    public Category findEntityByName(String name) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
return true;
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
