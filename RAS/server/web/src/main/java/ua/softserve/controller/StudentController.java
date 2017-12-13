package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.StudentStatuses;
import ua.softserve.service.StudentService;
import ua.softserve.service.StudentsStatusesService;
import ua.softserve.service.dto.EmployeeEngShortDto;
import ua.softserve.service.dto.StudentViewDto;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    StudentsStatusesService statusesService;

    @GetMapping("{id}")
    public List<StudentViewDto> getStudentsByAcademy(@PathVariable("id") Integer academyId) {
        return studentService.getStudentsByAcademy(academyId);
    }

    @GetMapping("statuses")
    public List<StudentStatuses> getAllStatuses() {
        return statusesService.findAll();
    }

    @GetMapping("employee")
    public List<EmployeeEngShortDto> getAllEmployees() {
        return studentService.getAllEmployees();
    }

    @PostMapping("{id}/add")
    public void addStudents(@PathVariable("id") Integer academyId, @RequestBody List<Integer> students) {
        studentService.addStudentsToAcademy(academyId, students);
    }

    @DeleteMapping("{studentId}")
    public void removeStudentFromAcademy(@PathVariable("studentId") Integer studentId) {
        studentService.removeStudentFromAcademy(studentId);
    }

    @PutMapping("update")
    public void updateStudentsOfAcademy(@RequestBody List<StudentViewDto> studentViewDtos) {
        studentService.updateStudentOfAcademy(studentViewDtos);
    }
}
