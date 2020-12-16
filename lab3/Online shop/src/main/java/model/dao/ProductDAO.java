package model.dao;

import model.entity.Category;
import model.entity.Color;
import model.entity.Product;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends BaseDAO<Integer, Product> {
    public static final String findAllProducts = "select * from product pr " +
            "inner join category c on pr.category_id = c.category_id " +
            "inner join color c2 on pr.color_id = c2.color_id";
    public static final String insertProduct = "insert into product(category_id,product_name," +
            "price,color_id,weight,date_added) values(?,?,?,?,?,?)";
    public final String deleteById = "delete from product where product_id = ?" ;
    public final String findProductById = "select * from product p " +
            "inner join category c on c.category_id = p.category_id" +
            " inner join color c2 on c2.color_id = p.color_id where product_id = ?";

    ProductDAO() throws SQLException {
        connection = connectionPool.getConnection();
    }
    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();

        try (ResultSet resultSet = connection.createStatement().executeQuery(findAllProducts)) {
            while (resultSet.next()) {
                products.add(new Product(
                        resultSet.getInt("product_id"),
                        new Category(resultSet.getString("category_name")),
                        resultSet.getString("product_name"),
                        resultSet.getDouble("price"),
                        new Color(resultSet.getString("color_name")),
                        resultSet.getDouble("weight"),
                        resultSet.getDate("date_added")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }

    @Override
    public List<Product> findAll(Integer parameter) {
        return null;
    }

    @Override
    public Product findEntityById(Integer id) {
        Product product = null;
        try (PreparedStatement ps = connection.prepareStatement(findProductById)) {
            ps.setInt(1, id);
            try(ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
                    product = new Product(
                            resultSet.getInt("product_id"),
                            new Category(resultSet.getInt("category_id"),resultSet.getString("category_name")),
                            resultSet.getString("product_name"),
                            resultSet.getDouble("price"),
                            new Color(resultSet.getInt("color_id"),resultSet.getString("color_name")),
                            resultSet.getDouble("weight"),
                            resultSet.getDate("date_added")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    @Override
    public Product findEntityByName(String name) throws SQLException {
        return null;
    }

    @Override
    public  void delete(Integer id) {
        int idd = id;
        try (PreparedStatement ps = connection.prepareStatement(deleteById)) {
            ps.setInt(1, idd);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        @Override
    public boolean deleteEntity(Product entity) {
        return false;
    }

    @Override
    public void create(Product entity)  {
        try (PreparedStatement ps = connection.prepareStatement(insertProduct)) {
            ps.setInt(1, entity.getCategory().getId());
            ps.setString(2, entity.getName());
            ps.setDouble(3, entity.getPrice());
            ps.setInt(4, entity.getColor().getId());
            ps.setDouble(5, entity.getWeight());
            ps.setDate(6, new Date(new java.util.Date().getTime()));
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product entity) {
        String updateUser = "update product set category_id=?,product_name=?, price=?, color_id=?, weight=?, date_added=? where product_id=?";
        try (PreparedStatement ps = connection.prepareStatement(updateUser)) {
            ps.setInt(1, entity.getCategory().getId());
            ps.setString(2, entity.getName());
            ps.setDouble(3, entity.getPrice());
            ps.setInt(4, entity.getColor().getId());
            ps.setDouble(5,entity.getWeight());
            ps.setDate(6,new Date(new java.util.Date().getTime()));
            ps.setInt(7,entity.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
