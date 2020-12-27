package application.model.service;



import application.domain.User;
import application.model.dao.AbstractDAO;
import application.model.dto.LoginDTO;
import application.model.dto.RegisterDTO;
import application.model.exception.BlockedUserException;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchUserException;
import application.model.exception.WrongPasswordException;

import java.sql.SQLException;
import java.util.UUID;

public class LoginService extends AbstractService {

    public User login(LoginDTO unauthorizedUser) throws NoSuchUserException, WrongPasswordException, MySQLException {
        AbstractDAO<UUID, User, RegisterDTO> dao = daoFactory.createDAO("user");
            User user = dao.findEntityByName(unauthorizedUser.getUsername());
            if (user == null)
                throw new NoSuchUserException();
             else if(!user.getPassword().equals(unauthorizedUser.getPassword()))
                    throw new WrongPasswordException("Incorrect password");
                else if(!user.isEnable()) throw new BlockedUserException();
        dao.closeConnection();
        return user;
    }
}


