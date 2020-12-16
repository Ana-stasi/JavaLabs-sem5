package model.dao;

import model.entity.Color;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorDAO extends BaseDAO<Integer, Color> {
    static final String findAllColor ="select * from color";
    ColorDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }
    @Override
    public List<Color> findAll() {
        List<Color> colors = new ArrayList<>();
        try (ResultSet resultSet = connection.createStatement().executeQuery(findAllColor)) {
            while (resultSet.next()) {
                colors.add(new Color(
                        resultSet.getInt("color_id"),
                        resultSet.getString("color_name")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return colors;
    }

    @Override
    public List<Color> findAll(Integer parameter) {
        return null;
    }

    @Override
    public Color findEntityById(Integer id) {
        return null;
    }

    @Override
    public Color findEntityByName(String name) throws SQLException {
        return null;
    }

    @Override
    public void delete(Integer id) {
    }

    @Override
    public boolean deleteEntity(Color entity) {
        return false;
    }

    @Override
    public void create(Color entity) throws SQLException {

    }

    @Override
    public void update(Color entity) {
    }
}
