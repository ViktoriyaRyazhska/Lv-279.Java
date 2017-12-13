package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.softserve.service.StudentService;
import ua.softserve.service.dto.StudentViewDto;

import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("{id}")
    public List<StudentViewDto> getStudentsByAcademy(@PathVariable("id") Integer academyId) {
        return studentService.getStudentsByAcademy(academyId);
    }

    @PostMapping("{id}/add")
    public void addStudents(@PathVariable("id") Integer academyId, @RequestBody List<Integer> students) {
        studentService.addStudentsToAcademy(academyId, students);
    }

    @DeleteMapping("{studentId}")
    public void removeStudentFromAcademy(@PathVariable("studentId") Integer studentId) {
        studentService.removeStudentFromAcademy(studentId);
    }

    @PutMapping
    public void updateStudentsOfAcademy(@RequestBody List<StudentViewDto> studentViewDtos) {
        studentService.updateStudentOfAcademy(studentViewDtos);
    }
}
