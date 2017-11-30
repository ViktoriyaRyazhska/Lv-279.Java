package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.service.EmployeeDirectionService;

@RestController
public class EmployeeDirectionController {
    @Autowired
    EmployeeDirectionService employeeDirectionService;

    @RequestMapping(value = "/remove-group-{empl_id}", method = RequestMethod.DELETE)
    public String removeGroupEmployee (@PathVariable int empl_id){
        employeeDirectionService.removeGroupEmployee(empl_id);
        return "showGroupStaff";
    }
}
