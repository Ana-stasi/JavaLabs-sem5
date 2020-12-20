package lab3.model.service.sort;

import lab3.model.entity.Product;

import java.util.Comparator;
import java.util.List;

public class DateSort implements SortStrategy {
    @Override
    public List<Product> sort(List<Product> list) {
        list.sort(Comparator.comparing(Product::getDateAdded));
        return list;
    }
}
