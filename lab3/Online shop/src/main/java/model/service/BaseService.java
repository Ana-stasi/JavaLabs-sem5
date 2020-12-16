package model.service;

import model.dao.DAOFactory;

import java.sql.SQLException;

public abstract class BaseService<M, T> {
    protected DAOFactory daoFactory;

    BaseService() {
        daoFactory = DAOFactory.getDaoFactory();
    }

    public abstract M performAction(T entity) throws SQLException;
}
