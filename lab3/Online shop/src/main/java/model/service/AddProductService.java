package model.service;

import model.dao.BaseDAO;
import model.entity.Product;

import java.sql.SQLException;

public class AddProductService extends BaseService<String,Product> {
    @Override
    public String performAction(Product product) throws SQLException {

            BaseDAO<Integer, Product> dao = daoFactory.createDAO("product");
            dao.create(product);
            dao.close();
            return "Product "+ product.getName()+" was added to catalogue";
    }
}
