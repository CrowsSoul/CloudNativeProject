package crows.restaurantms.userclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"crows.restaurantms.userclient.controller","crows.restaurantms.userclient.Client"})
@EnableEurekaClient
@EnableFeignClients("crows.restaurantms.userclient.Client")
public class UserClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserClientApplication.class, args);
    }

}
