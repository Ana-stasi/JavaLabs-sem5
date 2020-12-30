package application.model.service;

import application.domain.User;
import application.model.dao.AbstractDAO;
import application.model.dto.RegisterDTO;
import application.model.exception.MySQLException;
import application.model.exception.UnsupportedUsernameException;


import java.util.UUID;

public class RegistrationService extends AbstractService{

    public String register(RegisterDTO user) throws UnsupportedUsernameException, MySQLException {
        AbstractDAO<UUID, User,RegisterDTO> dao = daoFactory.createDAO("user");
        if (dao.findEntityByName(user.getUsername()) == null) {
            dao.create(user);
            dao.closeConnection();
        } else
            throw new UnsupportedUsernameException("label.registration_user_already_exist");

        return "registration_completed";

    }
}
