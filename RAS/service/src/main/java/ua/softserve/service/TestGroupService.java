package ua.softserve.service;

import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.TestGroup;

import java.util.Collection;
import java.util.List;

public interface TestGroupService {
    void saveCustom(int id,String role,int[] arr, EmployeeService employeeService);
    TestGroup findOne(int id);
}
