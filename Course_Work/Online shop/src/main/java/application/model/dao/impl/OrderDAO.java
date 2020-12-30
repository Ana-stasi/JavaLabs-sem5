package application.model.dao.impl;



import application.domain.Order;
import application.model.dao.AbstractDAO;
import application.model.exception.MySQLException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderDAO extends AbstractDAO<UUID, Order,Order> {

    public OrderDAO()throws MySQLException{
        super();
    }

    @Override
    public List<Order> findAll()throws MySQLException {
        String findAllOrders = " select order_id,u.user_id,username,price, status_name,created_at,order_number from orders o\n" +
                "inner join users u on o.user_id = u.user_id\n" +
                "inner join order_status os on os.status_id = o.status_id\n";
        List<Order> orders = new ArrayList<>();
        try( ResultSet resultSet = connection.createStatement().executeQuery(findAllOrders)){
            while (resultSet.next()) {
                orders.add(new Order(
                        UUID.fromString(resultSet.getString("order_id")),
                        UUID.fromString(resultSet.getString("user_id")),
                        resultSet.getString("username"),
                        resultSet.getDouble("price"),
                        resultSet.getString("status_name"),
                        resultSet.getDate("created_at"),
                        resultSet.getInt("order_number")
                ));
            }
        }catch (SQLException e){
            throw new MySQLException();
        }
        return orders;
    }

    @Override
    public List<Order> findAll(UUID userId) throws MySQLException {
        String findAllOrders = " select order_id,u.user_id,username,price, status_name,created_at,order_number from orders o\n" +
                "inner join users u on o.user_id = u.user_id\n" +
                "inner join order_status os on os.status_id = o.status_id\n" +
                "where o.user_id = ?";
        List<Order> orders = new ArrayList<>();
        try(PreparedStatement ps = connection.prepareStatement(findAllOrders)){
            ps.setObject(1, userId, Types.OTHER);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                orders.add(new Order(
                        UUID.fromString(resultSet.getString("order_id")),
                        UUID.fromString(resultSet.getString("user_id")),
                        resultSet.getString("username"),
                        resultSet.getDouble("price"),
                        resultSet.getString("status_name"),
                        resultSet.getDate("created_at"),
                        resultSet.getInt("order_number")
                ));
            }}catch (SQLException e){
            throw new MySQLException();
        }
        return orders;
    }


    @Override
    public Order findEntityById(UUID id) throws MySQLException {
        final String findOrderById = "select * from orders inner join order_status on orders.status_id = order_status.status_id" +
                "  where order_id =?  ";
        Order order = null;
        try(PreparedStatement ps = connection.prepareStatement(findOrderById)){
            ps.setObject(1, id, Types.OTHER);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                order = new Order(
                        UUID.fromString(resultSet.getString("order_id")),
                        UUID.fromString(resultSet.getString("user_id")),
                        resultSet.getDouble("price"),
                        resultSet.getString("status_name"),
                        resultSet.getDate("created_at")
                );
            }}catch (SQLException e){
            throw new MySQLException();
        }
        return order;
    }

    @Override
    public Order findEntityByName(String name) {
        return null;
    }

    @Override
    public boolean delete(UUID id) throws MySQLException {
        boolean result = false;
        String deleteById = "delete from product where product_id = ?" ;
        try(PreparedStatement ps = connection.prepareStatement(deleteById)){
            ps.setObject(1, id, Types.OTHER);
            result = ps.execute();}
        catch (SQLException e){
            throw new MySQLException();
        }return result;
    }

    @Override
    public void create(Order entity) {}

    @Override
    public void update(Order order) throws MySQLException {
        String updateOrder = "update orders set user_id=?, price=?, status_id=?, created_at=? " +
                "where order_id =?";
        try(PreparedStatement ps = connection.prepareStatement(updateOrder)) {
            ps.setObject(1, order.getUserId(), Types.OTHER);
            ps.setFloat(2, (float) order.getPrice());
            ps.setInt(3, order.getStatusId());
            ps.setDate(4, new Date(new java.util.Date().getTime()));
            ps.setObject(5, order.getId(), Types.OTHER);
            ps.execute();
        }catch (SQLException e){
            throw new MySQLException();
        }
    }

    @Override
    public void updateEntity(Order entity)  {

    }

}

