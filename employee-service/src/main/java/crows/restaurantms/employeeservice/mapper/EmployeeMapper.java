package crows.restaurantms.employeeservice.mapper;

import crows.restaurantms.employeeservice.po.Employee;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM Employee WHERE EmployeeID = #{id}")
    Employee findById(Integer id);

    @Update("UPDATE Employee SET EmployeeName=#{employeeName}, Position=#{position}, " +
            "Salary=#{salary}, Address=#{address}, Tel=#{tel}, SupervisorID=#{supervisorId} " +
            "WHERE EmployeeID=#{employeeId}")
    int update(Employee employee);

    @Select("SELECT COUNT(*) FROM OrderMenuItemCooker WHERE CookerID = #{employeeId}")
    int countAssignedDishes(Integer employeeId);

    @Select("SELECT * FROM Employee")
    List<Employee> findAll();

    @Delete("DELETE FROM Employee WHERE EmployeeID = #{id}")
    int delete(Integer id);
}
