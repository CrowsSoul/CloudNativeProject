package crows.restaurantms.orderclient.model;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Order {
    private Integer orderId;
    private LocalDate orderDate;
    private String customer;
}