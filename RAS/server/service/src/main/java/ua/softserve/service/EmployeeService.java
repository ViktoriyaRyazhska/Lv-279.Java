package ua.softserve.service;

import ua.softserve.persistence.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findEmployeesByLoginUserId(int loginUser_id);

    List<Employee> findEmployeesByTeacherType();

    Employee findOne(Integer id);
}
