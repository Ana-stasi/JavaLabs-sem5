package model.service.sort;

import model.entity.Product;

import java.util.List;

public class PriceSortDESC implements SortStrategy {
    @Override
    public List<Product> sort(List<Product> list) {
        list.sort((product, nextProduct) -> Double.compare(nextProduct.getPrice(), product.getPrice()));
        return list;
    }
}
