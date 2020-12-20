package lab3.model.service.sort;

import lab3.model.entity.Product;

import java.util.ArrayList;
import java.util.List;

public class NameSortASC implements SortStrategy {
    @Override
    public List<Product> sort(List<Product> list) {
        list.sort((product, nextProduct) -> product.getName().compareToIgnoreCase(nextProduct.getName()));
        return new ArrayList<>(list);
    }

}
