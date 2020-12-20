package lab3.model.dao;

import lab3.model.entity.Color;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ColorDAO extends AbstractDAO<Integer, Color> {
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
         String findColorById = "select * from color where color_id = ?";
        Color color = null;
        try (PreparedStatement ps = connection.prepareStatement(findColorById)) {
            ps.setInt(1, id);
            try(ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    color = new Color(
                            resultSet.getInt("color_id"),
                            resultSet.getString("color_name")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return color;
    }

    @Override
    public Color findEntityByName(String name) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(Integer id) {
        return true;
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
