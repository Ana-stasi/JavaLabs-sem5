package lab3.model.dao;
import lab3.model.entity.OrderLine;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

public class OrderLineDAO extends AbstractDAO<UUID, OrderLine> {
    public OrderLineDAO() throws SQLException {
        connection = connectionPool.getConnection();
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
    public OrderLine findEntityByName(String name) throws SQLException {
        return null;
    }

    @Override
    public boolean delete(UUID id) {
return true;
    }

    @Override
    public boolean deleteEntity(OrderLine entity) {
        return false;
    }

    @Override
    public void create(OrderLine entity){

            try (PreparedStatement ps = connection.prepareStatement(insertOrderLine)) {
                ps.setObject(1, entity.getOrderId(), java.sql.Types.OTHER);
                ps.setInt(2, entity.getProductId());
                ps.setInt(3, entity.getAmount());
                ps.setDouble(4, entity.getTotalCost());
                ps.execute();
            } catch (SQLException e) {
                e.printStackTrace();
        }
    }

    @Override
    public void update(OrderLine entity) {
    }
}
