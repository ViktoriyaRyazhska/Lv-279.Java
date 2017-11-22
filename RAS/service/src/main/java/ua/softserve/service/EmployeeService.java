package ua.softserve.service;

import org.springframework.data.domain.Page;
import ua.softserve.persistence.dao.TestGroupDAO;
import ua.softserve.persistence.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    List<Employee> findEmployeesWithItaRoles(String role);
    Page<Employee> getEmployeeLog(Integer pageNumber,String role);
    Page<Employee> getEmployeeLogFromFirstOrLastName(Integer pageNumber,String firstname,String lastname,String role);
    Employee findOne(int id);
}
