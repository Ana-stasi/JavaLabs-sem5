package application.model.dao.impl;

import application.domain.User;
import application.model.dao.AbstractDAO;
import application.model.dto.RegisterDTO;
import application.model.exception.MySQLException;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserDAO extends AbstractDAO<UUID, User, RegisterDTO> {

    public UserDAO() throws MySQLException {
        super();
    }

    @Override
    public List<User> findAll() throws MySQLException {
        String findAllUsers = " select * from users u join role r on u.role_id = r.role_id";
        List<User> users = new ArrayList<>();
        try(ResultSet resultSet = connection.createStatement().executeQuery(findAllUsers)) {
            while (resultSet.next()) {
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
            throw new MySQLException();
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
    public User findEntityByName(String name) throws MySQLException {
        String findByUsername = "select user_id,name as roleType, username,password,email,enable" +
                " from users u  join role r on u.role_id = r.role_id " +
                " where username = ?";
        User user = null;
        try(PreparedStatement ps = connection.prepareStatement(findByUsername)) {
            ps.setString(1, name);
            ResultSet resultSet = ps.executeQuery();
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
        }catch (SQLException e){
            throw new MySQLException();
        }
        return user;
    }

    @Override
    public boolean delete(UUID id) {
        return false;
    }

    @Override
    public void create(RegisterDTO user) throws MySQLException {
        String insertUser = "insert into users(user_id, role_id,username,password,email,enable) " +
                "values(?,?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(insertUser)) {
            ps.setObject(1, UUID.randomUUID(), java.sql.Types.OTHER);
            ps.setInt(2, 2);
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());
            ps.setBoolean(6, true);
            ps.execute();
        }catch (SQLException e){
            throw new MySQLException();
        }
    }

    @Override
    public void update(RegisterDTO entity)  {

    }

    @Override
    public void updateEntity(User user) throws MySQLException {
        String updateUser = "update users set user_id=?,role_id=?, username=?, password=?, email=?, enable=? where username=?";
        try(PreparedStatement ps = connection.prepareStatement(updateUser)) {
            ps.setObject(1, user.getId(), java.sql.Types.OTHER);
            ps.setInt(2, user.getIntRole());
            ps.setString(3, user.getUsername());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getEmail());
            ps.setBoolean(6, user.isEnable());
            ps.setString(7, user.getUsername());
            ps.execute();
        }catch (SQLException e){
            throw new MySQLException();
        }
    }


}
