package crows.restaurantms.orderservice.mapper;

import crows.restaurantms.orderservice.po.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Insert("INSERT INTO Orders(OrderDate, Customer) VALUES(#{orderDate}, #{customer})")
    @Options(useGeneratedKeys = true, keyProperty = "orderId")
    int insert(Order order);

    @Select("SELECT * FROM Orders")
    List<Order> findAll();

    @Select("SELECT * FROM Orders WHERE OrderID = #{id}")
    Order findById(@Param("id") Integer id);

    @Select("SELECT COUNT(1) FROM Orders WHERE OrderID = #{id}")
    boolean existsById(@Param("id") Integer id);

    @Update("UPDATE Orders SET OrderDate = #{orderDate}, Customer = #{customer} WHERE OrderID = #{orderId}")
    int update(Order order);

    // 新增：删除订单
    @Delete("DELETE FROM Orders WHERE OrderID = #{id}")
    int deleteById(@Param("id") Integer id);
}
