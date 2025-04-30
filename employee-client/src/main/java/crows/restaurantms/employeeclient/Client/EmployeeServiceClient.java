package crows.restaurantms.employeeclient.Client;

import crows.restaurantms.employeeclient.model.Employee;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "employee-service", fallback = EmployeeServiceFallback.class)
public interface EmployeeServiceClient {

    /**
     * 根据员工ID查询员工信息
     */
    @GetMapping("/findById/{id}")
    Employee findById(@PathVariable("id") Integer id);

    /**
     * 查询所有员工
     */
    @GetMapping("/queryAllEmployee")
    List<Employee> findAll();

    /**
     * 更新员工信息
     */
    @PutMapping("/update")
    int updateEmployee(@RequestBody Employee employee);

    /**
     * 删除员工
     */
    @DeleteMapping("/delete/{id}")
    int deleteEmployee(@PathVariable("id") Integer id);

    /**
     * 查询员工分配的菜品数量
     */
    @GetMapping("/countAssignedDishes/{employeeId}")
    int countAssignedDishes(@PathVariable("employeeId") Integer employeeId);
}
