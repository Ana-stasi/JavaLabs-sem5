package lab3.model.entity;

import java.util.Date;
import java.util.UUID;

public class Order{
    private UUID id;
    private UUID userId;
    private String username;
    private double price = 0;
    private String status = "registered";
    private Date cteatedAt;

    public Order(UUID id, UUID userId,String username, double price, String status, Date cteatedAt) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.price = price;
        this.status = status;
        this.cteatedAt = cteatedAt;
    }

    public Order(UUID orderId,UUID userId,double price, String status, Date cteatedAt) {
        this.id = orderId;
        this.userId = userId;
        this.price = price;
        this.status = status;
        this.cteatedAt = cteatedAt;
    }

    public Order(UUID orderId, UUID userId) {
        this.id = orderId;
        this.userId = userId;
    }

    public Order(UUID orderId, UUID userId, double price) {
        this.id = orderId;
        this.userId = userId;
        this.price = price;
    }

    public UUID getId() {
        return id;
    }

    public UUID getUserId() {
        return userId;
    }

    public double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }
    public int getStatusId(){
        if(this.status.equals("canceled")) return 3;
        else if(this.status.equals("paid")) return 2;
        else return 1;
    }

    public void setStatusId(int statusId) {
        if (statusId == 1) this.status = "registered";
        else if(statusId == 2) this.status = "paid";
        else this.status ="canceled";
    }

    @Override
    public String toString() {
        return String.format(" %15s| %15f |%15s | %10s",
                username,price,status,cteatedAt );
    }
}
