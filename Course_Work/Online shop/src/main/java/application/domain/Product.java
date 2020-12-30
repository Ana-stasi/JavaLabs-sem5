package application.domain;

import java.util.Date;
import java.util.Objects;

public class Product {
    private int id;
    private Category category;
    private String name;
    private double price;
    private Color color;
    private double weight;
    private Date dateAdded;


    public Product(int id, Category category, String name, double price, Color color, double weight, Date dateAdded) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.color = color;
        this.weight = weight;
        this.dateAdded = dateAdded;
    }

    public Product(Category category, String name, double price, Color color, double weight) {
        this.category = category;
        this.name = name;
        this.price = price;
        this.color = color;
        this.weight = weight;
    }

    public Product(int id, Category category, String name, double price, Color color, double weight) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.price = price;
        this.color = color;
        this.weight = weight;
    }



    public int getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Color getColor() {
        return color;
    }

    public double getWeight() {
        return weight;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && Double.compare(product.price, price) == 0 &&
                Double.compare(product.weight, weight) == 0 && Objects.equals(category, product.category)
                && Objects.equals(name, product.name) && Objects.equals(color, product.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, category, name, price, color, weight);
    }
}
