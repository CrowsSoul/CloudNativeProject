package crows.restaurantms.userservice.controller;

import crows.restaurantms.userservice.mapper.UserMapper;
import crows.restaurantms.userservice.po.User;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class UserController {

    private final UserMapper userMapper;

    /**
     * 根据用户ID查询用户信息
     */
    @GetMapping("/findById/{id}")
    public User findById(@PathVariable Integer id) {
        User user = userMapper.findById(id);
        log.info("-------------OK   /findById/{id}--------------------");
        return user;
    }

    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/findByUsername/{username}")
    public User findByUsername(@PathVariable String username) {
        User user = userMapper.findByUsername(username);
        log.info("-------------OK   /findByUsername/{username}--------------------");
        return user;
    }

    /**
     * 查询所有用户
     */
    @GetMapping("/queryAllUser")
    public List<User> findAll() {
        List<User> userList = userMapper.findAll();
        log.info("-------------OK   queryAllUser--------------------");
        return userList;
    }

    /**
     * 创建新用户
     */
    @PostMapping("/create")
    public int createUser(@RequestBody User user) {
        int result = userMapper.insert(user);
        log.info("-------------OK   create--------------------");
        return result;
    }

    /**
     * 更新用户信息
     */
    @PutMapping("/update")
    public int updateUser(@RequestBody User user) {
        int result = userMapper.update(user);
        log.info("-------------OK   update--------------------");
        return result;
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/delete/{id}")
    public int deleteUser(@PathVariable Integer id) {
        int result = userMapper.delete(id);
        log.info("-------------OK   delete/{id}--------------------");
        return result;
    }

    /**
     * 用户登录验证
     */
    @PostMapping("/login")
    public User login(@RequestParam String username, @RequestParam String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            log.info("-------------OK   login success--------------------");
            return user;
        }
        log.info("-------------FAIL   login failed--------------------");
        return null;
    }
}
