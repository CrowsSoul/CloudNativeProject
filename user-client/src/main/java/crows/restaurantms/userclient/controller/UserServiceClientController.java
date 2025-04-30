package crows.restaurantms.userclient.controller;

import crows.restaurantms.userclient.Client.UserServiceClient;
import crows.restaurantms.userclient.model.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class UserServiceClientController {

    private final UserServiceClient userServiceClient;

    /**
     * 根据用户ID查询用户信息
     */
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Integer id) {
        User user = userServiceClient.findById(id);
        log.info("--------------In client findById---------------------");
        return user;
    }

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/findByUsername/{username}")
    public User findByUsername(@PathVariable String username) {
        User user = userServiceClient.findByUsername(username);
        log.info("--------------In client findByUsername---------------------");
        return user;
    }

    /**
     * 查询所有用户
     */
    @GetMapping("/queryAllUser")
    public List<User> findAll() {
        List<User> userList = userServiceClient.findAll();
        log.info("--------------In client queryAllUser---------------------");
        return userList;
    }

    /**
     * 创建新用户
     */
    @PostMapping("/create")
    public int createUser(@RequestBody User user) {
        int result = userServiceClient.createUser(user);
        log.info("--------------In client createUser---------------------");
        return result;
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/update")
    public int updateUser(@RequestBody User user) {
        int result = userServiceClient.updateUser(user);
        log.info("--------------In client updateUser---------------------");
        return result;
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/delete/{id}")
    public int deleteUser(@PathVariable Integer id) {
        int result = userServiceClient.deleteUser(id);
        log.info("--------------In client deleteUser---------------------");
        return result;
    }

    /**
     * 用户登录验证
     */
    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        User user = userServiceClient.login(username, password);
        log.info("--------------In client login---------------------");
        return user;
    }
}
