package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.softserve.service.StudentService;
import ua.softserve.service.dto.StudentViewDto;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<StudentViewDto> getStudentsByAcademy(@PathVariable("id") Integer academyId) {
        return studentService.getStudentsByAcademy(academyId);
    }

    @PostMapping("academy/{id}")
    @CrossOrigin(origins = "http://localhost:4200")
    public void addStudents(@PathVariable("id") Integer academyId, @RequestBody Integer students) {

        System.out.println("Worked");
//        try {
//            System.out.println("WHAAAAT 1");
//            studentService.addStudentsToAcademy(1, Arrays.asList(students));
//            System.out.println("WHAAAAT 2");
//        } catch (Throwable e) {
//            e.printStackTrace();
//        }
    }
}
