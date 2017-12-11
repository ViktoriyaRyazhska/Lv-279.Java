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
    public void addStudents(@PathVariable("id") Integer academyId,
                            @RequestBody List<Integer> students) {
        studentService.addStudentsToAcademy(academyId, students);
    }

    @DeleteMapping("{academyId}/{id}")
    public void removeStudentFromAcademy(@PathVariable("academyId") Integer academyId,
                                         @PathVariable("id") Integer studentId) {
        studentService.removeStudentFromAcademy(academyId, studentId);
    }

    @PutMapping("{id}")
    public void updateStudentsOfAcademy(@PathVariable("id") Integer academyId,
                                        @RequestBody List<StudentViewDto> studentViewDtos) {
        studentService.updateStudentOfAcademy(academyId, studentViewDtos);
    }
}
