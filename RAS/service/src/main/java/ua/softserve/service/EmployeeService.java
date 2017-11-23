package ua.softserve.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import ua.softserve.persistence.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    List<Employee> findEmployeesWithItaRoles(String role);
    Page<Employee> getEmployeeLog(Integer pageNumber,String role);
    Page<Employee> getEmployeeLogFromInput(Integer pageNumber, String firstname, String lastname, String role);
    Employee findOne(int id);
}
