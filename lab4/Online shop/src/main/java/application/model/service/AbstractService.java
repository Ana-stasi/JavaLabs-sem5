package application.model.service;


import application.model.dao.DAOFactory;

public abstract class AbstractService {
    protected DAOFactory daoFactory;

    AbstractService() {
        daoFactory = DAOFactory.getDaoFactory();
    }

}
