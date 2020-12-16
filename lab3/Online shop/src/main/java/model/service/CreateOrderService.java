package model.service;

import model.dao.BaseDAO;
import model.entity.Order;
import model.entity.Product;

import java.sql.SQLException;
import java.util.UUID;

public class CreateOrderService extends BaseService<String, Order> {
    @Override
    public String performAction(Order entity) throws SQLException {

        BaseDAO<UUID, Order> dao = null;

            dao = daoFactory.createDAO("order");
            dao.create(entity);
            dao.close();

        return "Your order was sucessfully created";
    }

}
