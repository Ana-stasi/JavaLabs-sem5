package lab3.model.dao;

import lab3.model.entity.Order;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class OrderDAO extends AbstractDAO<UUID, Order> {

    public OrderDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }

    @Override
    public List<Order> findAll() {
        String findAllOrders = " select order_id,u.user_id,username,price, status_name,created_at from orders o\n" +
                "inner join users u on o.user_id = u.user_id\n" +
                "inner join order_status os on os.status_id = o.status_id\n";
        List<Order> orders = new ArrayList<>();
            try(ResultSet resultSet = connection.createStatement().executeQuery(findAllOrders)) {
                while (resultSet.next()) {
                    orders.add(new Order(
                            UUID.fromString(resultSet.getString("order_id")),
                            UUID.fromString(resultSet.getString("user_id")),
                            resultSet.getString("username"),
                            resultSet.getDouble("price"),
                            resultSet.getString("status_name"),
                            resultSet.getDate("created_at")
                    ));
                }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }

    @Override
    public List<Order> findAll(UUID userId) {
        String findAllOrders = " select order_id,u.user_id,username,price, status_name,created_at from orders o\n" +
                "inner join users u on o.user_id = u.user_id\n" +
                "inner join order_status os on os.status_id = o.status_id\n" +
                "where o.user_id = ?";
        List<Order> orders = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement(findAllOrders)) {
            ps.setObject(1, userId, java.sql.Types.OTHER);
        try(ResultSet resultSet = ps.executeQuery()) {
            while (resultSet.next()) {
                orders.add(new Order(
                        UUID.fromString(resultSet.getString("order_id")),
                        UUID.fromString(resultSet.getString("user_id")),
                        resultSet.getString("username"),
                        resultSet.getDouble("price"),
                        resultSet.getString("status_name"),
                        resultSet.getDate("created_at")
                ));
            }
        }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return orders;
    }


    @Override
    public Order findEntityById(UUID id) {
        final String findOrderById = "select * from orders inner join order_status on orders.status_id = order_status.status_id" +
                "  where order_id =?  ";
        Order order = null;
        try (PreparedStatement ps = connection.prepareStatement(findOrderById)) {
            ps.setObject(1, id, java.sql.Types.OTHER);
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    order = new Order(
                            UUID.fromString(resultSet.getString("order_id")),
                            UUID.fromString(resultSet.getString("user_id")),
                            resultSet.getDouble("price"),
                            resultSet.getString("status_name"),
                            resultSet.getDate("created_at")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    @Override
    public Order findEntityByName(String name) {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        boolean result = false;
        String deleteById = "delete from product where product_id = ?" ;
        try (PreparedStatement ps = connection.prepareStatement(deleteById)) {
            ps.setObject(1, id, java.sql.Types.OTHER);
            result = ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }return result;
    }

    @Override
    public boolean deleteEntity(Order entity) {
        return false;
    }

    @Override
    public void create(Order entity) {
        String insertOrder = "insert into orders(order_id,user_id,price,status_id,created_at) " +
                "values(?,?,?,?,?)";

        if (findEntityById(entity.getId()) == null) {
            try (PreparedStatement ps = connection.prepareStatement(insertOrder)) {
                ps.setObject(1, entity.getId(), java.sql.Types.OTHER);
                ps.setObject(2, entity.getUserId(), java.sql.Types.OTHER);
                ps.setDouble(3, entity.getPrice());
                ps.setInt(4, entity.getStatusId());
                ps.setDate(5, new Date(new java.util.Date().getTime()));
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else update(entity);
    }

    @Override
    public void update(Order order) {
        String updateOrder = "update orders set user_id=?, price=?, status_id=?, created_at=? " +
                              "where order_id =?";
        try (PreparedStatement ps = connection.prepareStatement(updateOrder)) {
            ps.setObject(1, order.getUserId(), java.sql.Types.OTHER);
            ps.setFloat(2, (float) order.getPrice());
            ps.setInt(3,  order.getStatusId());
            ps.setDate(4, new Date(new java.util.Date().getTime()));
            ps.setObject(5, order.getId(), java.sql.Types.OTHER);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

