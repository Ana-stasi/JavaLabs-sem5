package model.dao;

import exceptions.InvalidTypeException;

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

    public BaseDAO createDAO(String daoType) throws SQLException {
        switch (daoType) {
            case "user":
                return new UserDAO();
            case "order":
                return new OrderDAO();
            case "product":
                return new ProductDAO();
            case "orderLine":
                return new OrderLineDAO();
            case "category":
                return new CategoryDAO();
            case "color":
                return new ColorDAO();
            default:
                throw new InvalidTypeException();
        }
    }
}
