package lab3.model.service.sort;

import lab3.model.entity.Product;

import java.util.List;

public interface SortStrategy {
    List<Product> sort(List<Product> list);
}
