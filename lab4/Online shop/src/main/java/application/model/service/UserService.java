package application.model.service;



import application.domain.User;
import application.model.dao.AbstractDAO;
import application.model.dto.RegisterDTO;
import application.model.exception.EmptyCatalogueException;
import application.model.exception.InvalidTypeException;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchUserException;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class UserService extends AbstractService {

    public String editStatus(User selectedUser) throws InvalidTypeException, MySQLException {
        AbstractDAO<UUID, User, RegisterDTO> dao = daoFactory.createDAO("user");
        User user = dao.findEntityByName(selectedUser.getUsername());
        if (user != null) {
            user.setEnable(selectedUser.isEnable());
            dao.updateEntity(user);
            dao.closeConnection();
        } else throw new NoSuchUserException();

        return " User status was updated";
    }

    public List<User> getUsers() throws EmptyCatalogueException, MySQLException {
        AbstractDAO<UUID, User,RegisterDTO> dao = daoFactory.createDAO("user");
        List<User> users = dao.findAll();
        dao.closeConnection();
        if (users != null) {
            users.removeIf(user -> user.getRole().equals("admin"));
        } else throw new EmptyCatalogueException("There are no registered users");
        return users;
    }

    public User findByName(String username) throws NoSuchUserException, MySQLException {
        AbstractDAO<UUID, User,RegisterDTO> dao = daoFactory.createDAO("user");
        User user = dao.findEntityByName(username);
        dao.closeConnection();
        if (user!= null && user.getUsername().equals(username))
            return user;
        else throw new NoSuchUserException("User with such username doesn`t exist");
    }

}
