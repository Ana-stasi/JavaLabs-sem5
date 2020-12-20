package lab3.model.service;

import lab3.model.dao.DAOFactory;

import java.sql.SQLException;

public abstract class BaseService {
    protected DAOFactory daoFactory;

    BaseService() {
        daoFactory = DAOFactory.getDaoFactory();
    }

}
