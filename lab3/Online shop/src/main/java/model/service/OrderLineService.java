package lab3.model.service;

import lab3.model.dao.AbstractDAO;
import lab3.model.entity.OrderLine;

import java.sql.SQLException;
import java.util.UUID;

public class OrderLineService extends BaseService {

    public String performAction(OrderLine entity) throws SQLException {
            AbstractDAO<UUID, OrderLine> dao = daoFactory.createDAO("orderLine");
            dao.create(entity);
            dao.closeConnection();
        return "";
    }
}
