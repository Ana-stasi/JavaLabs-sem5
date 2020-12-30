package application.model.dao.impl;


import application.domain.OrderLine;
import application.model.dao.AbstractDAO;
import application.model.exception.MySQLException;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class OrderLineDAO extends AbstractDAO<UUID, OrderLine, OrderLine> {
    public OrderLineDAO() throws MySQLException {
       super();
    }

    static final String insertOrderLine = "insert into order_line(order_id,product_id,amount,total_cost) " +
            "values(?,?,?,?)";

    @Override
    public List<OrderLine> findAll() {
        return null;
    }

    @Override
    public List<OrderLine> findAll(UUID parameter) {
        return null;
    }

    @Override
    public OrderLine findEntityById(UUID id) {
        return null;
    }

    @Override
    public OrderLine findEntityByName(String name) throws MySQLException {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
        return true;
    }

    @Override
    public void create(OrderLine entity) throws MySQLException {
        try(PreparedStatement ps = connection.prepareStatement(insertOrderLine)) {
            ps.setObject(1, entity.getOrderId(), java.sql.Types.OTHER);
            ps.setInt(2, entity.getProductId());
            ps.setInt(3, entity.getAmount());
            ps.setDouble(4, entity.getTotalCost());
            ps.execute();
        }catch (SQLException e){
            throw new MySQLException();
        }

    }

    @Override
    public void update(OrderLine entity) {
    }

    @Override
    public void updateEntity(OrderLine entity) throws MySQLException {

    }
}
