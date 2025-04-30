package crows.restaurantms.userclient.Client;

import crows.restaurantms.userclient.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class UserServiceFallback implements UserServiceClient {

    @Override
    public User findById(Integer id) {
        log.error("UserService - findById fallback triggered, id: {}", id);
        User user = new User();
        user.setUsername("[Fallback] User Not Available");
        return user;
    }

    @Override
    public User findByUsername(String username) {
        log.error("UserService - findByUsername fallback triggered, username: {}", username);
        User user = new User();
        user.setUsername("[Fallback] User Not Available");
        return user;
    }

    @Override
    public List<User> findAll() {
        log.error("UserService - findAll fallback triggered");
        return Collections.emptyList();
    }

    @Override
    public int createUser(User user) {
        log.error("UserService - createUser fallback triggered, username: {}", user.getUsername());
        return -1;
    }

    @Override
    public int updateUser(User user) {
        log.error("UserService - updateUser fallback triggered, userId: {}", user.getUserID());
        return -1;
    }

    @Override
    public int deleteUser(Integer id) {
        log.error("UserService - deleteUser fallback triggered, id: {}", id);
        return -1;
    }

    @Override
    public User login(String username, String password) {
        log.error("UserService - login fallback triggered, username: {}", username);
        return null;
    }
}
