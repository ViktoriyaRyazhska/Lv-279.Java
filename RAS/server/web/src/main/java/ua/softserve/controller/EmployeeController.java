package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.GroupInfoTeachersService;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GroupInfoTeachersService groupInfoTeachersService;

    @GetMapping("/teachers")
    public ResponseEntity<List<Employee>> getTeachers() {
        return new ResponseEntity<List<Employee>>(employeeService.findEmployeesByTeacherType(), HttpStatus.OK);
    }

    @GetMapping("/experts")
    public ResponseEntity<List<Employee>> getExperts() {
        return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/isassigned/{id}")
    public Boolean isAssigned(@PathVariable("id") Integer id) {
        return groupInfoTeachersService.isAssignToGroup(id);
    }
}
