package crows.restaurantms.orderservice.po;

import lombok.Data;
import java.time.LocalDate;

@Data
public class Order {
    private Integer orderId;
    private LocalDate orderDate;
    private String customer;
}
