package lab3.model.entity;


import java.util.Date;

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
    public String toString() {
        return String.format("%3d |%20s | %30s | %.2f\t | %15s | %.2f\t | %10s",
                            id, category.getName(),name,price,color.getName(),weight,dateAdded);
    }
}
