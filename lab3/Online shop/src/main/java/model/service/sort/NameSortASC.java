package model.service.sort;

import model.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class NameSortASC implements SortStrategy {
    @Override
    public List<Product> sort(List<Product> list) {
        list.sort((product, nextProduct) -> product.getName().compareToIgnoreCase(nextProduct.getName()));
        return new ArrayList<>(list);
    }

}
