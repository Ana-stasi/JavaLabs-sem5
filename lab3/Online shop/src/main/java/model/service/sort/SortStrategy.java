package model.service.sort;

import model.entity.Product;

import java.util.List;

public interface SortStrategy {
    List<Product> sort(List<Product> list);
}
