package crows.restaurantms.orderclient.controller;

import crows.restaurantms.orderclient.Client.OrderServiceClient;
import crows.restaurantms.orderclient.model.Order;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class OrderServiceClientController {

    @Qualifier("crows.restaurantms.orderclient.Client.OrderServiceClient")
    @Autowired
    private final OrderServiceClient orderServiceClient;

    /**
     * 创建新订单
     */
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        Order createdOrder = orderServiceClient.createOrder(order);
        log.info("--------------In client createOrder---------------------");
        return createdOrder;
    }

    /**
     * 查询所有订单
     */
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        List<Order> orders = orderServiceClient.getAllOrders();
        log.info("--------------In client getAllOrders---------------------");
        return orders;
    }

    /**
     * 根据ID查询订单
     */
    @GetMapping("/orders/{id}")
    public Order getOrderById(@PathVariable Integer id) {
        Order order = orderServiceClient.getOrderById(id);
        log.info("--------------In client getOrderById---------------------");
        return order;
    }

    /**
     * 更新订单信息
     */
    @PutMapping("/orders/{id}")
    public void updateOrder(@PathVariable Integer id, @RequestBody Order order) {
        orderServiceClient.updateOrder(id, order);
        log.info("--------------In client updateOrder---------------------");
    }

    /**
     * 删除订单
     */
    @DeleteMapping("/orders/{id}")
    public void deleteOrder(@PathVariable Integer id) {
        orderServiceClient.deleteOrder(id);
        log.info("--------------In client deleteOrder---------------------");
    }

    /**
     * 检查订单是否存在
     */
    @GetMapping("/orders/{id}/exists")
    public boolean checkOrderExists(@PathVariable Integer id) {
        boolean exists = orderServiceClient.checkOrderExists(id);
        log.info("--------------In client checkOrderExists---------------------");
        return exists;
    }
}
