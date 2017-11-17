package ua.softserve.service;

import ua.softserve.data.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void save(Employee employee);
    List<Employee> findAll();
    List<Employee> findEmployeesWithItaRoles(String role);
}
