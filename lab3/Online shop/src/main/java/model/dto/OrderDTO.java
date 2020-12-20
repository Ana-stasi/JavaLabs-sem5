package lab3.model.dto;


import java.util.UUID;

public class OrderDTO {
    private UUID id;
    private UUID userId;
    private double price = 0;
    private String status = "registered";

    public OrderDTO(UUID id, UUID userI) {
        this.id = id;
        this.userId = userId;
    }
}
