package model.service;

import exceptions.InvalidTypeException;
import exceptions.NoSuchUserException;
import model.dao.BaseDAO;
import model.entity.User;

import java.sql.SQLException;
import java.util.UUID;

public class EditUserStatusService extends BaseService<String,User> {

    @Override
    public String performAction(User entity) throws InvalidTypeException, SQLException {
        BaseDAO<UUID,User> dao = null;
            dao = daoFactory.createDAO("user");
            User user = dao.findEntityByName(entity.getUsername());
            if(user != null){
                user.setEnable(entity.isEnable());
                dao.update(user);
                dao.close();
            }else throw new NoSuchUserException();

        return " User status was updated";
    }

}
