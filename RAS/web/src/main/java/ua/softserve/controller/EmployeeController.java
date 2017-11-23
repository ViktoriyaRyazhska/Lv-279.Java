package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.service.AcademyService;
import ua.softserve.service.EmployeeService;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AcademyService academyService;

    @GetMapping(value = "/group-{groupId}/pages-{pageNumber}-{role}")
    public String getRunbookPage(@PathVariable Integer pageNumber,
                                 @PathVariable String role,
                                 @PathVariable int groupId,
                                 Model model){
        Page<Employee> page = employeeService.getEmployeeLog(pageNumber,role);

        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("allEmployees",page.getContent());
        model.addAttribute("deploymentLog", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("role",role);
        model.addAttribute("groupId",groupId);

        return "showEmployees";
    }

    @GetMapping("/group-{groupId}/pages-1-{role}-search")
    public String searchEngNames(@PathVariable String role,
                                 @PathVariable int groupId,
                                 @RequestParam("firstname") String firstname,
                                 @RequestParam("lastname") String lastname,
                                 Model model){
        Page<Employee> page = employeeService.getEmployeeLogFromInput(1,firstname,lastname,role);
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("allEmployees",page.getContent());
        model.addAttribute("deploymentLog", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("role",role);
        model.addAttribute("groupId",groupId);
        model.addAttribute("modelfirstname",firstname);
        model.addAttribute("modellastname",lastname);

        return "showEmployees";
    }

    @PostMapping("/group-{groupId}/include-{role}")
    public String includeEmployees(@RequestParam("arr") int[] arr,
                                   @PathVariable String role,
                                   @PathVariable int groupId){
        academyService.saveCustom(groupId,role,arr,employeeService);
        return "index";
    }

}
