package application.model.service;


import application.domain.Product;
import application.model.dao.AbstractDAO;
import application.model.dto.ProductDTO;
import application.model.exception.EmptyCatalogueException;
import application.model.exception.MySQLException;
import application.model.exception.NoSuchProductException;

import java.util.Comparator;
import java.util.List;

public class ProductService extends AbstractService {

    public String addProduct(ProductDTO product) throws MySQLException {
            AbstractDAO<Integer, Product, ProductDTO> dao = daoFactory.createDAO("product");
            dao.create(product);
            dao.closeConnection();
            return  "label.product_added_to_catalogue";
    }
    public String updateProduct(ProductDTO product) throws MySQLException {
        AbstractDAO<Integer, Product,ProductDTO> dao = daoFactory.createDAO("product");
        dao.update(product);
        dao.closeConnection();
        return "label.update_product";
    }

    public Product findProduct(int id) throws NoSuchProductException,MySQLException {
        AbstractDAO<Integer, Product,Product> dao = daoFactory.createDAO("product");
        Product product = dao.findEntityById(id);
        if(product!=null)
            return  product;
        else throw new NoSuchProductException();
    }

    public String deleteProduct(Integer productId) throws MySQLException {
        AbstractDAO<Integer, Product,Product> dao = daoFactory.createDAO("product");
            dao.delete(productId);
        dao.closeConnection();
           return  "label.was_removed";
    }

    public List<Product> getProductList(String sortType) throws EmptyCatalogueException, MySQLException {

        AbstractDAO<Integer, Product,Product> dao = daoFactory.createDAO("product");
        List<Product> products = dao.findAll();
        dao.closeConnection();
        if(products != null)
            return sort(products,sortType);
        else throw new EmptyCatalogueException();
    }

    private List<Product> sort(List<Product> products,String sortType){
        switch (sortType) {
            case "1"://NAme asc
                products.sort((product, nextProduct) -> product.getName().compareToIgnoreCase(nextProduct.getName()));
                return products;
            case "2"://name desc
                products.sort((product, nextProduct) -> nextProduct.getName().compareToIgnoreCase(product.getName()));
                return products;
            case "3"://price asc
                products.sort(Comparator.comparingDouble(Product::getPrice));
                return products;
            case "4"://price desc
                products.sort((product, nextProduct) -> Double.compare(nextProduct.getPrice(), product.getPrice()));
                return products;
            case "5"://date asc
                products.sort(Comparator.comparing(Product::getDateAdded));
            default:
                return products;
        }

    }

}
