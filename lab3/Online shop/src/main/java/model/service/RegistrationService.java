package lab3.model.service;

import lab3.controller.exceptions.UnsupportedUsernameException;
import lab3.model.dao.AbstractDAO;
import lab3.model.entity.User;

import java.sql.SQLException;
import java.util.UUID;

public class RegistrationService extends BaseService {

    public String register(User user) throws SQLException {
        AbstractDAO<UUID, User> dao = daoFactory.createDAO("user");
            if (dao.findEntityByName(user.getUsername()) == null) {
                dao.create(user);
                dao.closeConnection();
            } else
                throw new UnsupportedUsernameException("User with such username already exists");

        return "Your registration was successfully completed!";

    }
}
