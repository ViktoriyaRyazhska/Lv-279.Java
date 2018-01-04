package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.LoginUser;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.GroupInfoTeachersService;
import ua.softserve.service.dto.GroupInfoTeachersDTO;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GroupInfoTeachersService groupInfoTeachersService;

    @GetMapping("/getemployee")
    public ResponseEntity<Employee> getEmployee() {
        return new ResponseEntity<Employee>(employeeService.findEmployeesByLoginUserId(((Optional<LoginUser>) SecurityContextHolder
                .getContext().getAuthentication().getPrincipal()).get().getId()), HttpStatus.OK);
    }

    @GetMapping("/experts")
    public ResponseEntity<List<Employee>> getExperts() {
        return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/isassigned/{id}")
    public Boolean isAssigned(@PathVariable("id") Integer id) {
        return groupInfoTeachersService.isAssignToGroup(id);
    }

    @PostMapping("/assign")
    public ResponseEntity addStudents(@RequestBody List<GroupInfoTeachersDTO> object) {
        groupInfoTeachersService.save(object);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/group/{id}")
    public ResponseEntity<List<GroupInfoTeachers>> getGroupInfoTeachers(@PathVariable("id") Integer id){
        return new ResponseEntity<List<GroupInfoTeachers>>(groupInfoTeachersService.findAllByAcademy_AcademyId(id), HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity updateGroupInfoTeachers(@RequestBody List<GroupInfoTeachers> groupInfoTeachers){
        groupInfoTeachersService.updateGroupInfoTeachers(groupInfoTeachers);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteGroupInfoTeachers(@PathVariable("id") Integer id){
        groupInfoTeachersService.deleteGroupInfoTeachers(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
