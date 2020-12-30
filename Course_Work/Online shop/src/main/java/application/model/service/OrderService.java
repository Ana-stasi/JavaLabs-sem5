package application.model.service;



import application.domain.Order;
import application.model.dao.AbstractDAO;
import application.model.exception.EmptyCatalogueException;
import application.model.exception.MySQLException;
import application.model.exception.NoOrderException;

import java.util.List;
import java.util.UUID;

public class OrderService  extends AbstractService{

    public String addOrder(Order order) throws MySQLException {
        AbstractDAO<UUID, Order,Order> dao = daoFactory.createDAO("order");
            dao.create(order);
            dao.closeConnection();
            return "label.successfully_created_order";
    }

    public String deleteOrder(Order order) throws MySQLException {
        AbstractDAO<UUID, Order,Order> dao = daoFactory.createDAO("order");
        dao.delete(order.getId());
        dao.closeConnection();
        return  "label.delete_order";
    }

    public List<Order> getOrders(UUID userId) throws NoOrderException,MySQLException {
        AbstractDAO<UUID,Order,Order> dao = daoFactory.createDAO("order");
        List<Order> orders = dao.findAll(userId);
        dao.closeConnection();
        if(orders == null) throw new NoOrderException();
        else return orders;
    }

    public List<Order> getAllOrders() throws EmptyCatalogueException, MySQLException {
        AbstractDAO<UUID,Order,Order> dao = daoFactory.createDAO("order");
        List<Order> orders = dao.findAll();
        dao.closeConnection();
        if(orders == null|| orders.size()==0) throw new EmptyCatalogueException("No orders");
        return orders;
    }
    public String updateOrder(Order order) throws MySQLException {
        AbstractDAO<UUID,Order,Order> dao = daoFactory.createDAO("order");
        dao.update(order);
        return "label.update_order_status";
    }
}
