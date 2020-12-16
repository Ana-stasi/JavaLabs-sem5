package model.service;

import model.dao.BaseDAO;
import model.entity.Order;
import model.entity.OrderLine;

import java.sql.SQLException;
import java.util.UUID;

public class AddOrderLinesService extends BaseService<String, OrderLine> {
    @Override
    public String performAction(OrderLine entity) throws SQLException {
            BaseDAO<UUID, OrderLine> dao = daoFactory.createDAO("orderLine");
            dao.create(entity);
            dao.close();
        return "";
    }
}
