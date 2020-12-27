package application.model.dao;

import application.model.dao.impl.OrderDAO;
import application.model.dao.impl.OrderLineDAO;
import application.model.dao.impl.ProductDAO;
import application.model.dao.impl.UserDAO;
import application.model.exception.InvalidTypeException;
import application.model.exception.MySQLException;


import java.sql.SQLException;

public class DAOFactory {
    private static volatile DAOFactory daoFactory = null;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        if (daoFactory == null) {
            synchronized (DAOFactory.class) {
                if (daoFactory == null)
                    daoFactory = new DAOFactory();
            }
        }
        return daoFactory;
    }

    public AbstractDAO createDAO(String daoType) throws MySQLException {
        switch (daoType) {
            case "user":
                return new UserDAO();
            case "product":
                return new ProductDAO();
            case "order":
                return new OrderDAO();
            case "orderLine":
                return new OrderLineDAO();
            default:
                throw new InvalidTypeException();
        }
    }
}
