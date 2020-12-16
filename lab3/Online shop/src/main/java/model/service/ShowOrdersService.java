package model.service;

import model.dao.BaseDAO;
import model.entity.Order;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;


public class ShowOrdersService extends BaseService<List<Order>, UUID> {
    @Override
    public List<Order> performAction(UUID userId) throws SQLException {
        List<Order> orders = null;
            BaseDAO<UUID,Order> dao = daoFactory.createDAO("order");
            orders= dao.findAll(userId);

        return orders;
    }
}
