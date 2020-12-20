package lab3.model.service;

import lab3.model.dao.AbstractDAO;
import lab3.model.entity.Order;
import lab3.model.service.exceptions.EmptyCatalogueException;
import lab3.model.service.exceptions.NoOrderException;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OrderService extends BaseService {

    public String addOrder(Order order) throws SQLException {
        AbstractDAO<UUID, Order> dao = daoFactory.createDAO("order");
            dao.create(order);
            dao.closeConnection();
            return "Your order was successfully created";
    }

    public String deleteOrder(Order order) throws SQLException {
        AbstractDAO<UUID, Order> dao = daoFactory.createDAO("order");
        dao.delete(order.getId());
        dao.closeConnection();
        return  "There is nothing to save.Your shopping cart is empty";
    }

    public List<Order> getOrders(UUID userId) throws NoOrderException,SQLException {
        AbstractDAO<UUID,Order> dao = daoFactory.createDAO("order");
        List<Order> orders = dao.findAll(userId);
        dao.closeConnection();
        if(orders == null) throw new NoOrderException();
        else return orders;
    }

    public Map<Integer,Order> getAllOrders() throws EmptyCatalogueException, SQLException {
        AbstractDAO<UUID,Order> dao = daoFactory.createDAO("order");
        List<Order> orders = dao.findAll();
        dao.closeConnection();
        Map<Integer,Order> orderMap = new HashMap<>();
        if(orders != null){
            for (int i = 0; i<orders.size();i++) {
                orderMap.put(i,orders.get(i));
            }
        }else throw new EmptyCatalogueException("No orders");
        return orderMap;
    }
    public String updateOrder(Order order) throws SQLException {
        AbstractDAO<UUID,Order> dao = daoFactory.createDAO("order");
        dao.update(order);
        return "Order status was updated";
    }
}
