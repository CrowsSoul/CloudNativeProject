package crows.restaurantms.userclient.Client;

import crows.restaurantms.userclient.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "user-service", fallback = UserServiceFallback.class)
public interface UserServiceClient {

    /**
     * 根据用户ID查询用户信息
     */
    @GetMapping("/findById/{id}")
    User findById(@PathVariable("id") Integer id);

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/findByUsername/{username}")
    User findByUsername(@PathVariable("username") String username);

    /**
     * 查询所有用户
     */
    @GetMapping("/queryAllUser")
    List<User> findAll();

    /**
     * 创建新用户
     */
    @PostMapping("/create")
    int createUser(@RequestBody User user);

    /**
     * 更新用户信息
     */
    @PutMapping("/update")
    int updateUser(@RequestBody User user);

    /**
     * 删除用户
     */
    @DeleteMapping("/delete/{id}")
    int deleteUser(@PathVariable("id") Integer id);

    /**
     * 用户登录验证
     */
    @PostMapping("/login")
    User login(@RequestParam("username") String username, @RequestParam("password") String password);
}
