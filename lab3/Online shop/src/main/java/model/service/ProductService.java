package lab3.model.service;

import lab3.model.dao.AbstractDAO;
import lab3.model.entity.Product;
import lab3.model.service.exceptions.EmptyCatalogueException;
import lab3.model.service.sort.*;

import java.sql.SQLException;
import java.util.List;

public class ProductService extends BaseService {

    public String addProduct(Product product) throws SQLException {

            AbstractDAO<Integer, Product> dao = daoFactory.createDAO("product");
            dao.create(product);
            dao.closeConnection();
            return "Product "+ product.getName()+" was added to catalogue";
    }
    public String updateProduct(Product product) throws SQLException {

        AbstractDAO<Integer, Product> dao = daoFactory.createDAO("product");
        dao.update(product);
        dao.closeConnection();
        return "Product "+ product.getName()+" was updated";
    }
    public Product findProduct(int id) throws EmptyCatalogueException,SQLException {
        AbstractDAO<Integer, Product> dao = daoFactory.createDAO("product");
        Product product = dao.findEntityById(id);
        if(product!=null)
            return  product;
        else throw new EmptyCatalogueException("Product with such № doesn't exist");
    }
    public String deleteProduct(Integer productId) throws SQLException {
        AbstractDAO<Integer, Product> dao = daoFactory.createDAO("product");
            dao.delete(productId);
        dao.closeConnection();
           return  "Product №"+productId+" was successfully removed from catalogue";
    }

    public List<Product> getProductList(String sortType) throws EmptyCatalogueException, SQLException {

        AbstractDAO<Integer, Product> dao = daoFactory.createDAO("product");
        List<Product> products = dao.findAll();
        dao.closeConnection();
        if(products != null)
            return sort(products,sortType);
        else throw new EmptyCatalogueException();
    }
    private List<Product> sort(List<Product> products,String sortType){
        switch (sortType) {
            case "1":
                return new NameSortASC().sort(products);
            case "2":
                return new NameSortDESC().sort(products);
            case "3":
                return new PriceSortASC().sort(products);
            case "4":
                return new PriceSortDESC().sort(products);
            case "5":
                return new DateSort().sort(products);
            default:
                return products;
        }
    }

}
