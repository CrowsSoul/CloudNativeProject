package crows.restaurantms.employeeservice.controller;

import crows.restaurantms.employeeservice.mapper.EmployeeMapper;
import crows.restaurantms.employeeservice.po.Employee;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class EmployeeController {

    private final EmployeeMapper employeeMapper;

    /**
     * 根据员工ID查询员工信息
     */
    @GetMapping("/findById/{id}")
    public Employee findById(@PathVariable Integer id) {
        Employee employee = employeeMapper.findById(id);
        log.info("-------------OK   /findById/{id}--------------------");
        return employee;
    }

    /**
     * 查询所有员工
     */
    @GetMapping("/queryAllEmployee")
    public List<Employee> findAll() {
        List<Employee> employeeList = employeeMapper.findAll();
        log.info("-------------OK   queryAllEmployee--------------------");
        return employeeList;
    }

    /**
     * 更新员工信息
     */
    @PutMapping("/update")
    public int updateEmployee(@RequestBody Employee employee) {
        int result = employeeMapper.update(employee);
        log.info("-------------OK   update--------------------");
        return result;
    }

    /**
     * 删除员工
     */
    @DeleteMapping("/delete/{id}")
    public int deleteEmployee(@PathVariable Integer id) {
        int result = employeeMapper.delete(id);
        log.info("-------------OK   delete/{id}--------------------");
        return result;
    }

    /**
     * 查询员工分配的菜品数量
     */
    @GetMapping("/countAssignedDishes/{employeeId}")
    public int countAssignedDishes(@PathVariable Integer employeeId) {
        int count = employeeMapper.countAssignedDishes(employeeId);
        log.info("-------------OK   countAssignedDishes/{employeeId}--------------------");
        return count;
    }
}
