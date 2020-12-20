package lab3.model.service;

import lab3.controller.exceptions.InvalidTypeException;
import lab3.controller.exceptions.NoSuchUserException;
import lab3.model.dao.AbstractDAO;
import lab3.model.entity.User;
import lab3.model.service.exceptions.EmptyCatalogueException;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserService extends BaseService {

    public String editStatus(User selectedUser) throws InvalidTypeException, SQLException {
        AbstractDAO<UUID, User> dao = daoFactory.createDAO("user");
        User user = dao.findEntityByName(selectedUser.getUsername());
        if (user != null) {
            user.setEnable(selectedUser.isEnable());
            dao.update(user);
            dao.closeConnection();
        } else throw new NoSuchUserException();

        return " User status was updated";
    }

    public List<User> getUsers() throws EmptyCatalogueException, SQLException {
        AbstractDAO<UUID, User> dao = daoFactory.createDAO("user");
        List<User> users = dao.findAll();
        dao.closeConnection();
        if (users != null) {
            users.removeIf(user -> user.getUserRole().equals("admin"));
        } else throw new EmptyCatalogueException("There are no registered users");
        return users;
    }

    public User findByName(String username) throws NoSuchUserException, SQLException {
        AbstractDAO<UUID, User> dao = daoFactory.createDAO("user");
        User user = dao.findEntityByName(username);
        dao.closeConnection();
        if (user!= null && user.getUsername().equals(username))
            return user;
        else throw new NoSuchUserException("User with such username doesn`t exist");
    }

}
