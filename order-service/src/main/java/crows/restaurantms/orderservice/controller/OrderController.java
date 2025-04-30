package crows.restaurantms.orderservice.controller;

import crows.restaurantms.orderservice.mapper.OrderMapper;
import crows.restaurantms.orderservice.po.Order;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class OrderController {

    private final OrderMapper orderMapper;

    /**
     * 创建新订单
     */
    @PostMapping("/orders")
    public Order createOrder(@RequestBody Order order) {
        orderMapper.insert(order);
        log.info("-------------OK   POST /orders--------------------");
        return order; // 返回包含生成ID的订单对象
    }

    /**
     * 查询所有订单
     */
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        List<Order> orders = orderMapper.findAll();
        log.info("-------------OK   GET /orders--------------------");
        return orders;
    }

    /**
     * 根据ID查询订单
     */
    @GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Integer id) {
        Order order = orderMapper.findById(id);
        if (order != null) {
            log.info("-------------OK   GET /orders/{id}--------------------");
            return ResponseEntity.ok(order);
        } else {
            log.warn("-------------Not Found   GET /orders/{id}--------------------");
            return ResponseEntity.notFound().build();
        }
    }

    /**
     * 更新订单信息
     */
    @PutMapping("/orders/{id}")
    public ResponseEntity<Void> updateOrder(@PathVariable Integer id, @RequestBody Order order) {
        if (!orderMapper.existsById(id)) {
            log.warn("-------------Not Found   PUT /orders/{id}--------------------");
            return ResponseEntity.notFound().build();
        }
        order.setOrderId(id); // 确保ID一致
        orderMapper.update(order);
        log.info("-------------OK   PUT /orders/{id}--------------------");
        return ResponseEntity.ok().build();
    }

    /**
     * 删除订单
     */
    @DeleteMapping("/orders/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Integer id) {
        if (!orderMapper.existsById(id)) {
            log.warn("-------------Not Found   DELETE /orders/{id}--------------------");
            return ResponseEntity.notFound().build();
        }
        orderMapper.deleteById(id);
        log.info("-------------OK   DELETE /orders/{id}--------------------");
        return ResponseEntity.ok().build();
    }

    /**
     * 检查订单是否存在
     */
    @GetMapping("/orders/{id}/exists")
    public boolean checkOrderExists(@PathVariable Integer id) {
        boolean exists = orderMapper.existsById(id);
        log.info("-------------OK   GET /orders/{id}/exists--------------------");
        return exists;
    }
}
