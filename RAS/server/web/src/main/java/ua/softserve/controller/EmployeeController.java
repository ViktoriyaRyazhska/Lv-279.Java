// package ua.softserve.controller;
//
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.data.domain.Page;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import ua.softserve.persistence.entity.Employee;
// import ua.softserve.persistence.entity.EmployeeDirection;
// import ua.softserve.service.AcademyService;
// import ua.softserve.service.EmployeeDirectionService;
// import ua.softserve.service.EmployeeService;
//
// import java.util.List;
//
// @Controller
// public class EmployeeController {
// @Autowired
// EmployeeService employeeService;
// @Autowired
// AcademyService academyService;
// @Autowired
// EmployeeDirectionService employeeDirectionService;
//
// @GetMapping(value = "/group-{groupId}/pages-{pageNumber}-{role}")
// public String getRunbookPage(@PathVariable Integer pageNumber,
// @PathVariable String role,
// @PathVariable int groupId,
// Model model){
// Page<Employee> page = employeeService.getEmployeeLog(pageNumber,role);
//
// int current = page.getNumber() + 1;
// int begin = Math.max(1, current - 5);
// int end = Math.min(begin + 10, page.getTotalPages());
//
// model.addAttribute("allEmployees",page.getContent());
// model.addAttribute("deploymentLog", page);
// model.addAttribute("beginIndex", begin);
// model.addAttribute("endIndex", end);
// model.addAttribute("currentIndex", current);
// model.addAttribute("role",role);
// model.addAttribute("groupId",groupId);
//
// return "showEmployees";
// }
//
// @GetMapping("/group-{groupId}/pages-1-{role}-search")
// public String searchEngNames(@PathVariable String role,
// @PathVariable int groupId,
// @RequestParam("firstname") String firstname,
// @RequestParam("lastname") String lastname,
// Model model){
// Page<Employee> page = employeeService.getEmployeeLogFromInput(1,firstname,lastname,role);
// int current = page.getNumber() + 1;
// int begin = Math.max(1, current - 5);
// int end = Math.min(begin + 10, page.getTotalPages());
//
// model.addAttribute("allEmployees",page.getContent());
// model.addAttribute("deploymentLog", page);
// model.addAttribute("beginIndex", begin);
// model.addAttribute("endIndex", end);
// model.addAttribute("currentIndex", current);
// model.addAttribute("role",role);
// model.addAttribute("groupId",groupId);
// model.addAttribute("modelfirstname",firstname);
// model.addAttribute("modellastname",lastname);
//
// return "showEmployees";
// }
//
// @PostMapping("/group-{groupId}/include-{role}")
// public String includeEmployees(@RequestParam(required = false) int[] arr,
// @PathVariable String role,
// @PathVariable int groupId,
// Model model){
// if (arr==null){
// model.addAttribute("checkforarr",arr);
// return "redirect:/group-"+groupId+"/pages-1-"+role;
// }
// academyService.saveCustom(groupId,role,arr,employeeService);
// return "redirect:/group-"+groupId+"/pages-1-"+role;
// }
//
// @GetMapping("/showGroupStaff-{groupId}")
// public ResponseEntity<List <EmployeeDirection>> showAllInfoEmployees (@PathVariable int groupId) {
// return new ResponseEntity<List
// <EmployeeDirection>>(employeeDirectionService.findAllEmployeesDirectionsByGroupId(groupId), HttpStatus.OK);
// }
//
//
// @GetMapping("/remove-group-{empl_id}")
// public String removeGroupEmployee (@PathVariable int empl_id,Model model){
// employeeDirectionService.removeGroupEmployee(empl_id);
// return "index";
// }
// }
