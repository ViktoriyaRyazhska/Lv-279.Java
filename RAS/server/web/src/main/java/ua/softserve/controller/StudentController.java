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
import java.util.NoSuchElementException;

@RestController
@RequestMapping("students")
public class StudentController {
    private final Logger logger = LoggerFactory.getLogger(StudentController.class.getName());

    @Autowired
    StudentService studentService;

    @Autowired
    StudentsStatusesService statusesService;

    @GetMapping(value = {"{id}", "/get-group-overview-report/{id}"})
    public ResponseEntity getStudentsByAcademy(@PathVariable("id") Integer academyId) {
        try {
            logger.info("Get students from group with id: " + academyId);
            return new ResponseEntity<List<StudentViewDto>>(studentService.getStudentsByAcademy(academyId), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Group with id " + academyId + " not found");
        }
    }

    @GetMapping("statuses")
    public ResponseEntity<List<StudentStatuses>> getAllStatuses() {
        logger.info("Get student statuses");
        return new ResponseEntity<List<StudentStatuses>>(statusesService.findAll(), HttpStatus.OK);
    }

    @GetMapping("employee")
    public ResponseEntity<List<EmployeeEngShortDto>> getAllEmployees() {
        logger.info("Get employees");
        return new ResponseEntity<List<EmployeeEngShortDto>>(studentService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("{id}/add")
    public ResponseEntity addStudents(@PathVariable("id") Integer academyId, @RequestBody List<Integer> students) {
        if (studentService.addStudentsToAcademy(academyId, students)) {
            logger.info("Students successfully added");
            return new ResponseEntity(HttpStatus.OK);
        } else {
            logger.info("Bad request");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update")
    public ResponseEntity updateStudentsOfAcademy(@RequestBody List<StudentViewDto> studentViewDtos) {
        if (studentService.updateStudentsOfAcademy(studentViewDtos)) {
            logger.info("Students successfully update");
            return new ResponseEntity(HttpStatus.OK);
        } else {
            logger.info("Bad request");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("{studentId}")
    public ResponseEntity removeStudentFromAcademy(@PathVariable("studentId") Integer studentId) {
        if (studentService.removeStudentFromAcademy(studentId)) {
            logger.info("Delete students from group with id: " + studentId);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            logger.info("Bad request");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }
}
