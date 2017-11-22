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

    static final int id=1;

    @GetMapping(value = "/pages-{pageNumber}-{role}")
    public String getRunbookPage(@PathVariable Integer pageNumber,
                                 @PathVariable String role,
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

        return "showEmployees";
    }

    @GetMapping("/pages-1-{role}-search")
    public String searchEngNames(@PathVariable String role,
                                 @RequestParam("texttosearch") String texttosearch,
                                 Model model){
        Page<Employee> page = employeeService.getEmployeeLogFromFirstOrLastName(1,texttosearch,texttosearch,role);
        int current = page.getNumber() + 1;
        int begin = Math.max(1, current - 5);
        int end = Math.min(begin + 10, page.getTotalPages());

        model.addAttribute("allEmployees",page.getContent());
        model.addAttribute("deploymentLog", page);
        model.addAttribute("beginIndex", begin);
        model.addAttribute("endIndex", end);
        model.addAttribute("currentIndex", current);
        model.addAttribute("role",role);
        return "showEmployees";
    }

    @PostMapping("/include-{role}")
    public String includeEmployees(@RequestParam("arr") int[] arr,
                                   @PathVariable String role){
        academyService.saveCustom(id,role,arr,employeeService);
        return "index";
    }

}
