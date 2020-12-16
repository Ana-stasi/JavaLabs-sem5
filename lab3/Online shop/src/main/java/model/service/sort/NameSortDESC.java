package model.service.sort;

import model.entity.Product;

import java.util.*;

public class NameSortDESC implements SortStrategy {
    @Override
    public List<Product> sort(List<Product> list) {

        list.sort((product, nextProduct) -> nextProduct.getName().compareToIgnoreCase(product.getName()));
        return new ArrayList<>(list);
    }
}
