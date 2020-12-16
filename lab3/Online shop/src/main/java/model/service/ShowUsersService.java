package model.service;

import model.dao.BaseDAO;
import model.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class ShowUsersService extends BaseService<List<User>,String>{
    @Override
    public List<User> performAction(String entity) throws SQLException {
        List<User> users = null;

            BaseDAO<UUID, User> dao = daoFactory.createDAO("user");
             users = dao.findAll();
            dao.close();

        return users;
    }
}
