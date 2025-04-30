package crows.restaurantms.employeeclient.model;

import lombok.Data;

@Data
public class Employee {
    private Integer employeeId;
    private String employeeName;
    private Integer salary;
    private String position;
    private String address;
    private String tel;
    private Integer supervisorId;
}

