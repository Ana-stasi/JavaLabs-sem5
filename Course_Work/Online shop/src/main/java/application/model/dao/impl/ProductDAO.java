package application.model.dao.impl;


import application.domain.Category;
import application.domain.Color;
import application.domain.Product;
import application.model.dao.AbstractDAO;
import application.model.dto.ProductDTO;
import application.model.exception.MySQLException;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO extends AbstractDAO<Integer, Product, ProductDTO> {
    public static final String findAllProducts = "select * from product pr " +
            "inner join category c on pr.category_id = c.category_id " +
            "inner join color c2 on pr.color_id = c2.color_id";
    public static final String insertProduct = "insert into product(category_id,product_name," +
            "price,color_id,weight,date_added) values(?,?,?,?,?,?)";

    public final String findProductById = "select * from product p " +
            "inner join category c on c.category_id = p.category_id" +
            " inner join color c2 on c2.color_id = p.color_id where product_id = ?";

    public ProductDAO() throws MySQLException {
        super();
    }

    @Override
    public List<Product> findAll() throws MySQLException {
        List<Product> products = new ArrayList<>();
        try(ResultSet resultSet = connection.createStatement().executeQuery(findAllProducts)) {
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
        }catch (SQLException e){
            throw new MySQLException();
        }
        return products;
    }

    @Override
    public List<Product> findAll(Integer parameter) {
        return null;
    }

    @Override
    public Product findEntityById(Integer id) throws MySQLException {
        Product product = null;
        try(PreparedStatement ps = connection.prepareStatement(findProductById)) {
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                product = new Product(
                        resultSet.getInt("product_id"),
                        new Category(resultSet.getInt("category_id"), resultSet.getString("category_name")),
                        resultSet.getString("product_name"),
                        resultSet.getDouble("price"),
                        new Color(resultSet.getInt("color_id"), resultSet.getString("color_name")),
                        resultSet.getDouble("weight"),
                        resultSet.getDate("date_added")
                );
            }
        }catch (SQLException e){
            throw  new MySQLException();
        }
        return product;
    }

    @Override
    public Product findEntityByName(String name) {
        return null;
    }

    @Override
    public boolean delete(Integer id) throws MySQLException {
        boolean result = false;
        String deleteById = "delete from product where product_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(deleteById)) {
            ps.setInt(1, id);
            result = ps.execute();
        }catch (SQLException e){
            throw new MySQLException();
        }
        return result;
    }

    @Override
    public void create(ProductDTO product) throws MySQLException {
        try(PreparedStatement ps = connection.prepareStatement(insertProduct)) {
            ps.setInt(1, product.getCategoryId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getColorId());
            ps.setDouble(5, product.getWeight());
            ps.setDate(6, new Date(new java.util.Date().getTime()));
            ps.execute();
        }catch (SQLException e){
            throw new MySQLException();
        }

    }

    @Override
    public void update(ProductDTO product) throws MySQLException {
        String updateUser = "update product set category_id=?,product_name=?, price=?, color_id=?, weight=?, date_added=? where product_id=?";
        try(PreparedStatement ps = connection.prepareStatement(updateUser)) {
            ps.setInt(1, product.getCategoryId());
            ps.setString(2, product.getName());
            ps.setDouble(3, product.getPrice());
            ps.setInt(4, product.getColorId());
            ps.setDouble(5, product.getWeight());
            ps.setDate(6, new Date(new java.util.Date().getTime()));
            ps.setInt(7, product.getProductId());
            ps.execute();
        }catch (SQLException e){
            throw new MySQLException();
        }
    }

    @Override
    public void updateEntity(Product entity)  {

    }

}
