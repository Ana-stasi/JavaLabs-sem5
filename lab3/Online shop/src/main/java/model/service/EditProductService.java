package model.service;

import model.dao.BaseDAO;
import model.entity.Product;

import java.sql.SQLException;

public class EditProductService extends BaseService<String, Product> {
    @Override
    public String performAction(Product product) throws SQLException {

            BaseDAO<Integer, Product> dao = daoFactory.createDAO("product");
            dao.update(product);
            dao.close();

        return "Product №"+product.getId()+" was edited";
    }
}
