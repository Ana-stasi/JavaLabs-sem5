package lab3.model.service;

import lab3.controller.exceptions.BlockedUserException;
import lab3.controller.exceptions.NoSuchUserException;
import lab3.controller.exceptions.WrongPasswordException;
import lab3.model.dao.AbstractDAO;
import lab3.model.dto.LoginDTO;
import lab3.model.entity.User;
import lab3.model.entity.UserSession;

import java.sql.SQLException;
import java.util.UUID;

public class LoginService extends BaseService {

    public String login(LoginDTO unauthorizedUser) throws NoSuchUserException, WrongPasswordException, SQLException {
        AbstractDAO<UUID, User> dao = daoFactory.createDAO("user");
            User user = dao.findEntityByName(unauthorizedUser.getUsername());
            if (user == null) {
                throw new NoSuchUserException();
            } else {
                if (!user.getPassword().equals(unauthorizedUser.getPassword()))
                    throw new WrongPasswordException("Incorrect password");
                else {
                    if(!user.isEnable()) throw new BlockedUserException();
                    else UserSession.setUserSession(user.getId(), user.getUsername(), user.getUserRole(), user.isEnable());
                    dao.closeConnection();
                }
            }
        return "\nWelcome, " + UserSession.getUserSession().getUsername();
    }
}


