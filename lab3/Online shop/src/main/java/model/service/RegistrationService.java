package model.service;

import exceptions.UnsupportedUsernameException;
import model.dao.BaseDAO;
import model.entity.User;

import java.sql.SQLException;
import java.util.UUID;

public class RegistrationService extends BaseService<String, User> {

    RegistrationService() {
    }

    @Override
    public String performAction(User entity) throws SQLException {
        BaseDAO<UUID, User> dao = null;

            dao = daoFactory.createDAO("user");
            if (dao.findEntityByName(entity.getUsername()) == null) {
                dao.create(entity);
                dao.close();
            } else
                throw new UnsupportedUsernameException("User with such username already exists");

        return "Your registration was successfully completed!";

    }
}
