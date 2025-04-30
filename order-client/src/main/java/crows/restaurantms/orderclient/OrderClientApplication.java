package crows.restaurantms.orderclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"crows.restaurantms.orderclient.controller","crows.restaurantms.orderclient.Client"})
@EnableEurekaClient
@EnableFeignClients("crows.restaurantms.orderclient.Client")
public class OrderClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderClientApplication.class, args);
    }

}
