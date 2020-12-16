package model.entity;

import java.util.UUID;

public class OrderLine {
    private UUID orderId;
    private int productId;
    private int amount;
    private double totalCost;

    public OrderLine(UUID orderId, int productId, int amount, double totalCost) {
        this.orderId = orderId;
        this.productId = productId;
        this.amount = amount;
        this.totalCost = totalCost;
    }

    public UUID getOrderId() {
        return orderId;
    }

    public int getProductId() {
        return productId;
    }

    public int getAmount() {
        return amount;
    }

    public double getTotalCost() {
        return totalCost;
    }
}
