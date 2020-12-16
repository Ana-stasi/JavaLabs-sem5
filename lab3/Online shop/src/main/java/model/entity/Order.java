package model.entity;

import java.util.Date;
import java.util.UUID;

public class Order{
    private UUID id;
    private UUID userId;
    private String username;
    private double price;
    private String status;
    private Date cteatedAt;

    public Order(UUID id, UUID userId,String username, double price, String status, Date cteatedAt) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.price = price;
        this.status = status;
        this.cteatedAt = cteatedAt;
    }

    public Order(UUID orderId,UUID userId, double price, String status) {
        this.id = orderId;
        this.userId = userId;
        this.price = price;
        this.status = status;
    }

    public Order(UUID orderId,UUID userId,double price, String status, Date cteatedAt) {
        this.id = orderId;
        this.userId = userId;
        this.price = price;
        this.status = status;
        this.cteatedAt = cteatedAt;
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
        if(this.status.equals("registered")) return 1;
        else return 0;
    }


    public Date getCteatedAt() {
        return cteatedAt;
    }

    @Override
    public String toString() {
        return String.format(" %15s| %15f |%15s | %10s",
                username,price,status,cteatedAt );
    }
}
