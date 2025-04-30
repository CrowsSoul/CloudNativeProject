package crows.restaurantms.employeeclient.Client;

import crows.restaurantms.employeeclient.model.Employee;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class EmployeeServiceFallback implements EmployeeServiceClient {

    @Override
    public Employee findById(Integer id) {
        log.error("EmployeeService - findById fallback triggered, id: {}", id);
        Employee employee = new Employee();
        employee.setEmployeeName("[Fallback] Employee Not Available");
        return employee;
    }

    @Override
    public List<Employee> findAll() {
        log.error("EmployeeService - findAll fallback triggered");
        return Collections.emptyList(); // 返回空集合而不是null
    }

    @Override
    public int updateEmployee(Employee employee) {
        log.error("EmployeeService - updateEmployee fallback triggered, employeeId: {}", employee.getEmployeeId());
        return -1; // 用负数表示失败
    }

    @Override
    public int deleteEmployee(Integer id) {
        log.error("EmployeeService - deleteEmployee fallback triggered, id: {}", id);
        return -1;
    }

    @Override
    public int countAssignedDishes(Integer employeeId) {
        log.error("EmployeeService - countAssignedDishes fallback triggered, employeeId: {}", employeeId);
        return 0; // 返回0表示没有分配菜品
    }
}
