package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ua.softserve.persistence.dto.StudentsViewDto;
import ua.softserve.service.StudentService;

import java.util.List;

public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/group-{groupId}/students")
    public String searchEngNames(@PathVariable("groupId") Integer groupId, Model model){

        List<StudentsViewDto> list = studentService.getAllStudentsOfAcademy(groupId);


        return "showEmployees";
    }

}
