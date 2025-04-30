package crows.restaurantms.employeeclient.controller;

import crows.restaurantms.employeeclient.Client.EmployeeServiceClient;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import crows.restaurantms.employeeclient.model.Employee;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class EmployeeServiceClientController {

    @Qualifier("crows.restaurantms.employeeclient.Client.EmployeeServiceClient")
    @Autowired
    private final EmployeeServiceClient employeeServiceClient;

    /**
     * 根据员工ID查询员工信息
     */
    @GetMapping("/findById/{id}")
    public Employee findById(@PathVariable Integer id) {
        Employee employee = employeeServiceClient.findById(id);
        log.info("--------------In client findById---------------------");
        return employee;
    }

    /**
     * 查询所有员工
     */
    @GetMapping("/queryAllEmployee")
    public List<Employee> findAll() {
        List<Employee> employeeList = employeeServiceClient.findAll();
        log.info("--------------In client queryAllEmployee---------------------");
        return employeeList;
    }

    /**
     * 更新员工信息
     */
    @PutMapping("/update")
    public int updateEmployee(@RequestBody Employee employee) {
        int result = employeeServiceClient.updateEmployee(employee);
        log.info("--------------In client updateEmployee---------------------");
        return result;
    }

    /**
     * 删除员工
     */
    @DeleteMapping("/delete/{id}")
    public int deleteEmployee(@PathVariable Integer id) {
        int result = employeeServiceClient.deleteEmployee(id);
        log.info("--------------In client deleteEmployee---------------------");
        return result;
    }

    /**
     * 查询员工分配的菜品数量
     */
    @GetMapping("/countAssignedDishes/{employeeId}")
    public int countAssignedDishes(@PathVariable Integer employeeId) {
        int count = employeeServiceClient.countAssignedDishes(employeeId);
        log.info("--------------In client countAssignedDishes---------------------");
        return count;
    }
}
