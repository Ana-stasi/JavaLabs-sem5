package model.service;

import exceptions.BlockedUserException;
import exceptions.NoSuchUserException;
import exceptions.WrongPasswordException;
import model.dao.BaseDAO;
import model.dto.LoginDTO;
import model.entity.User;
import model.entity.UserSession;

import java.sql.SQLException;
import java.util.UUID;

public class LoginService extends BaseService<String, LoginDTO> {

    LoginService() {
    }

    public String performAction(LoginDTO unauthorizedUser) throws NoSuchUserException, WrongPasswordException, SQLException {
        BaseDAO<UUID, User> dao = null;

            dao = daoFactory.createDAO("user");
            User user = dao.findEntityByName(unauthorizedUser.getUsername());
            if (user == null) {
                throw new NoSuchUserException();
            } else {
                if (!user.getPassword().equals(unauthorizedUser.getPassword()))
                    throw new WrongPasswordException("Incorrect password");
                else {
                    if(!user.isEnable()) throw new BlockedUserException();
                    else UserSession.setUserSession(user.getId(), user.getUsername(), user.getUserRole(), user.isEnable());
                    dao.close();
                }
            }
        return "\nWelcome, " + UserSession.getUserSession().getUsername();
    }
}


