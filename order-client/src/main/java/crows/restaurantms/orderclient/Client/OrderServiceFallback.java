package crows.restaurantms.orderclient.Client;

import crows.restaurantms.orderclient.model.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class OrderServiceFallback implements OrderServiceClient {

    @Override
    public Order createOrder(Order order) {
        log.error("OrderService - createOrder fallback triggered");
        Order fallbackOrder = new Order();
        fallbackOrder.setOrderId(-1);
        fallbackOrder.setCustomer("[Fallback] Service Unavailable");
        return fallbackOrder;
    }

    @Override
    public List<Order> getAllOrders() {
        log.error("OrderService - getAllOrders fallback triggered");
        return Collections.singletonList(createFallbackOrder());
    }

    @Override
    public Order getOrderById(Integer id) {
        log.error("OrderService - getOrderById fallback triggered, id: {}", id);
        return createFallbackOrder();
    }

    @Override
    public void updateOrder(Integer id, Order order) {
        log.error("OrderService - updateOrder fallback triggered, id: {}", id);
    }

    @Override
    public void deleteOrder(Integer id) {
        log.error("OrderService - deleteOrder fallback triggered, id: {}", id);
    }

    @Override
    public boolean checkOrderExists(Integer id) {
        log.error("OrderService - checkOrderExists fallback triggered, id: {}", id);
        return false; // 默认返回不存在
    }

    private Order createFallbackOrder() {
        Order order = new Order();
        order.setOrderId(-1);
        order.setCustomer("[Fallback] Order Not Available");
        order.setOrderDate(LocalDate.now());
        return order;
    }
}
