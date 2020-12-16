package model.service;

import model.dao.BaseDAO;
import model.entity.Product;
import model.service.sort.*;

import java.sql.SQLException;
import java.util.List;

public class ShowCatalogueService extends BaseService<List<Product>, String> {

    @Override
    public List<Product> performAction(String sortType) throws SQLException {
        List<Product> products = null;
            BaseDAO<Integer, Product> dao = daoFactory.createDAO("product");
             products= dao.findAll();
            dao.close();

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
