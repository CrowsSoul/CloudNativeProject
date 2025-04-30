package crows.restaurantms.userservice.po;

import lombok.Data;

@Data
public class User {
    private Integer userID;
    private String username;
    private String password;
    private String role;
    private String email;
    private String createdAt;
}
