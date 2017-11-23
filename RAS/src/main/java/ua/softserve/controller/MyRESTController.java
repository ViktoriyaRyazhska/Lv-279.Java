package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.softserve.data.entity.Employee;
import ua.softserve.data.entity.User;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.UserService;

import java.util.List;

@RestController
public class MyRESTController {

    @Autowired
    UserService userService;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("/")
    public List<Employee> searchproduct (){
        return employeeService.findAll();
    }

    @GetMapping("/employees-{role}")
    public List<Employee> findEmployeesByRole(@PathVariable String role){
        return employeeService.findEmployeesWithItaRoles(role);
    }

    @GetMapping("find-{id}")
    public User getUserById(@PathVariable int id){
        return userService.findUserById(id);
    }

    @GetMapping("save-{firstname}")
    public void saveUserById(@PathVariable String firstname){
        userService.save(new User(firstname));
    }
    @GetMapping("save-em-{firstname}")
    public void saveEmployee(@PathVariable String firstname) {
        employeeService.save(new Employee(firstname));
    }

}
