package lab3.model.service.sort;

import lab3.model.entity.Product;

import java.util.*;

public class NameSortDESC implements SortStrategy {
    @Override
    public List<Product> sort(List<Product> list) {

        list.sort((product, nextProduct) -> nextProduct.getName().compareToIgnoreCase(product.getName()));
        return new ArrayList<>(list);
    }
}
