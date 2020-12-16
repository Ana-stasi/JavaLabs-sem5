package model.service;

import model.dao.BaseDAO;
import model.entity.Product;

import java.sql.SQLException;

public class DeleteProductService extends BaseService<String, Integer> {
    @Override
    public String performAction(Integer entity) throws SQLException {
        String result = null;
        BaseDAO<Integer, Product> dao = null;
            dao = daoFactory.createDAO("product");
            Product product = dao.findEntityById(entity);
            if(product!=null) {
                dao.delete(entity);
                result = "Product "+product.getId()+" was successfully removed from catalogue";
            }
            else result ="Such product doesn`t exist";
            dao.close();


        return result;
    }
}
