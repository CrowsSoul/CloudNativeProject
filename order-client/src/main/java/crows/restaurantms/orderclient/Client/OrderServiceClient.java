package crows.restaurantms.orderclient.Client;

import crows.restaurantms.orderclient.model.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "order-service", fallback = OrderServiceFallback.class)
public interface OrderServiceClient {

    /**
     * 创建新订单
     * @param order 订单信息
     * @return 创建成功的订单(包含生成的ID)
     */
    @PostMapping("/orders")
    Order createOrder(@RequestBody Order order);

    /**
     * 查询所有订单
     * @return 订单列表
     */
    @GetMapping("/orders")
    List<Order> getAllOrders();

    /**
     * 根据ID查询订单
     * @param id 订单ID
     * @return 订单信息
     */
    @GetMapping("/orders/{id}")
    Order getOrderById(@PathVariable("id") Integer id);

    /**
     * 更新订单信息
     * @param id 订单ID
     * @param order 更新后的订单信息
     */
    @PutMapping("/orders/{id}")
    void updateOrder(@PathVariable("id") Integer id, @RequestBody Order order);

    /**
     * 删除订单
     * @param id 要删除的订单ID
     */
    @DeleteMapping("/orders/{id}")
    void deleteOrder(@PathVariable("id") Integer id);

    /**
     * 检查订单是否存在
     * @param id 订单ID
     * @return 是否存在
     */
    @GetMapping("/orders/{id}/exists")
    boolean checkOrderExists(@PathVariable("id") Integer id);
}
