package model.service.sort;

import model.entity.Product;

import java.util.Comparator;
import java.util.List;

public class PriceSortASC implements SortStrategy {
    @Override
    public List<Product> sort(List<Product> list) {
        list.sort(Comparator.comparingDouble(Product::getPrice));
        return list;
    }
}
