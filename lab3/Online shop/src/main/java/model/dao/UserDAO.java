package lab3.model.dao;

import lab3.model.entity.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDAO extends AbstractDAO<UUID, User> implements BaseDAO<UUID, User> {

    UserDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }

    @Override
    public List<User> findAll() {
        String findAllUsers = " select * from users u join role r on u.role_id = r.role_id";
        List<User> users = new ArrayList<>();
        try(ResultSet resultSet = connection.createStatement().executeQuery(findAllUsers)) {
            while (resultSet.next()){
                users.add(new User(
                        UUID.fromString(resultSet.getString("user_id")),
                        resultSet.getString("name"),
                        resultSet.getString("username"),
                        resultSet.getString("password"),
                        resultSet.getString("email"),
                        resultSet.getBoolean("enable")
                ));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findAll(UUID parameter) {
        return null;
    }

    @Override
    public User findEntityById(UUID id) {
        return null;
    }

    @Override
    public User findEntityByName(String name){
        String findByUsername = "select user_id,name as roleType, username,password,email,enable" +
                " from users u  join role r on u.role_id = r.role_id " +
                " where username = ?";
        User user = null;
        try (PreparedStatement ps = connection.prepareStatement(findByUsername)) {
            ps.setString(1, name);
            try(ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    user = new User(
                            UUID.fromString(resultSet.getString("user_id")),
                            resultSet.getString("roleType"),
                            resultSet.getString("username"),
                            resultSet.getString("password"),
                            resultSet.getString("email"),
                            resultSet.getBoolean("enable")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public boolean deleteEntity(User entity) {
        return false;
    }

    @Override
    public void create(User entity) {
        String insertUser = "insert into users(user_id, role_id,username,password,email,enable) " +
                "values(?,?,?,?,?,?)";
        try (PreparedStatement ps = connection.prepareStatement(insertUser)) {
            ps.setObject(1, entity.getId(), java.sql.Types.OTHER);
            ps.setInt(2, entity.getRole());
            ps.setString(3, entity.getUsername());
            ps.setString(4, entity.getPassword());
            ps.setString(5, entity.getEmail());
            ps.setBoolean(6, entity.isEnable());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(User entity) {
        String updateUser = "update users set user_id=?,role_id=?, username=?, password=?, email=?, enable=? where username=?";
        try (PreparedStatement ps = connection.prepareStatement(updateUser)) {
            ps.setObject(1, entity.getId(), java.sql.Types.OTHER);
            ps.setInt(2, entity.getRole());
            ps.setString(3, entity.getUsername());
            ps.setString(4, entity.getPassword());
            ps.setString(5, entity.getEmail());
            ps.setBoolean(6, entity.isEnable());
            ps.setString(7,entity.getUsername());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
