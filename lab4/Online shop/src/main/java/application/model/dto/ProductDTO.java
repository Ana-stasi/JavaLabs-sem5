package application.model.dto;

import application.domain.Category;
import application.domain.Color;

public class ProductDTO {
    private int productId;
    private int categoryId;
    private  String name;
    private double price;
    private int colorId;
    private double weight;

    public ProductDTO(int productId, int categoryId, String name, double price, int colorId, double weight) {
        this.productId = productId;
        this.categoryId = categoryId;
        this.name = name;
        this.price = price;
        this.colorId = colorId;
        this.weight = weight;
    }

    public int getProductId() {
        return productId;
    }

    public ProductDTO(int category, String name, double price, int color, double weight) {
        this.categoryId = category;
        this.name = name;
        this.price = price;
        this.colorId = color;
        this.weight = weight;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public int getColorId() {
        return colorId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }
}
