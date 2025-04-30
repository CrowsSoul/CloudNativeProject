package crows.restaurantms.employeeclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"crows.restaurantms.employeeclient.controller","crows.restaurantms.employeeclient.Client"})
@EnableEurekaClient
@EnableFeignClients("crows.restaurantms.employeeclient.Client")
public class EmployeeClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeeClientApplication.class, args);
    }

}
