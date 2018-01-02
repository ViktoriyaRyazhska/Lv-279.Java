package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.Authority;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.repo.EmployeeRepository;
import ua.softserve.service.EmployeeService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findEmployeesByLoginUserId(int loginUser_id) {
        return employeeRepository.findEmployeesByLoginUserId(loginUser_id);
    }

    @Override
    public List<Employee> findEmployeesByTeacherType() {
        // return employeeRepository.findAll().stream()
        // .filter(employee -> employee.getLoginUser()!=null &&
        // employee.getLoginUser().getAuthoritiess().contains(Authority.TEACHER))
        // .collect(Collectors.toList());
        return new ArrayList<>();
    }

    @Override
    public Employee findOne(Integer id) {
        return employeeRepository.findOne(id);
    }
}
