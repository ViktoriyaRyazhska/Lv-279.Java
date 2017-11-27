package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.EmployeeRepository;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.service.EmployeeService;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    static final int MAXROW=8;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Transactional
    @Override
    public List<Employee> findEmployeesWithItaRoles(String role) {
        return employeeRepository.findEmployeesWithItaRoles(role);
    }

    @Transactional
    @Override
    public Page<Employee> getEmployeeLog(Integer pageNumber,String role) {
        PageRequest pageRequest=new PageRequest(pageNumber -1,MAXROW,Sort.Direction.ASC,"firstname","lastname");
        return employeeRepository.findEmployeesByItaroleRole(role,pageRequest);
    }

    @Transactional
    @Override
    public Page<Employee> getEmployeeLogFromInput(Integer pageNumber, String firstname, String lastname, String role) {
        PageRequest pageRequest=new PageRequest(pageNumber -1,MAXROW,Sort.Direction.ASC,"firstname","lastname");
        if (!firstname.equals("") && !lastname.equals("")){
            return employeeRepository.findEmployeesByItaroleRoleAndFirstnameLikeAndLastnameLike(role,firstname,lastname,pageRequest);
        }
        else if (!firstname.equals("") && lastname.equals("")){
            return employeeRepository.findEmployeesByItaroleRoleAndFirstnameLike(role,firstname,pageRequest);
        }
        else if (firstname.equals("") && !lastname.equals("")){
            return employeeRepository.findEmployeesByItaroleRoleAndLastnameLike(role,lastname,pageRequest);
        }
        else {
            return employeeRepository.findEmployeesByItaroleRole(role,pageRequest);
        }
    }

    @Transactional
    @Override
    public Employee findOne(int id) {
        return employeeRepository.findOne(id);
    }
}
