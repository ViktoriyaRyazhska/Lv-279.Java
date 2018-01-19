package ua.softserve.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    private final Logger logger = LoggerFactory.getLogger(StudentController.class.getName());

    @Autowired
    StudentService studentService;

    @Autowired
    StudentsStatusesService statusesService;

    @GetMapping("{id}")
    public ResponseEntity<List<StudentViewDto>> getStudentsByAcademy(@PathVariable("id") Integer academyId) {
        return new ResponseEntity<List<StudentViewDto>>(studentService.getStudentsByAcademy(academyId), HttpStatus.OK);
    }

    @GetMapping("statuses")
    public ResponseEntity<List<StudentStatuses>> getAllStatuses() {
        return new ResponseEntity<List<StudentStatuses>>(statusesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("employee")
    public ResponseEntity<List<EmployeeEngShortDto>> getAllEmployees() {
        return new ResponseEntity<List<EmployeeEngShortDto>>(studentService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("{id}/add")
    public ResponseEntity addStudents(@PathVariable("id") Integer academyId, @RequestBody List<Integer> students) {
        studentService.addStudentsToAcademy(academyId, students);
        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity removeStudentFromAcademy(@PathVariable("studentId") Integer studentId) {
        studentService.removeStudentFromAcademy(studentId);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("update")
    public ResponseEntity updateStudentsOfAcademy(@RequestBody List<StudentViewDto> studentViewDtos) {
        studentService.updateStudentsOfAcademy(studentViewDtos);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("update_student")
    public ResponseEntity updateStudentOfAcademy(@RequestBody StudentViewDto studentViewDtos) {
        studentService.updateStudentOfAcademy(studentViewDtos);
        return new ResponseEntity(HttpStatus.OK);
    }
}
