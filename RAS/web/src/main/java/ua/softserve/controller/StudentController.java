package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.dto.StudentsShortViewDto;
import ua.softserve.persistence.dto.StudentsViewDto;
import ua.softserve.service.StudentService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String showStudents(@RequestParam(value = "academyId", required = false) Integer academyId, Model model) {
        List<StudentsViewDto> students = academyId == null ?
                new ArrayList<>() :
                studentService.getAcceptedStudentsOfAcademy(academyId);
        model.addAttribute("academyId", academyId);
        model.addAttribute("students", students);
        return "showStudents";
    }

    @GetMapping("/students/{academyId}/add")
    public String showAddStudents(@PathVariable("academyId") Integer academyId, Model model) {
        List<StudentsShortViewDto> students = studentService.getStudentsOfAcademy(academyId);
        model.addAttribute("academyId", academyId);
        model.addAttribute("students", students);
        return "addStudents";
    }

    @PostMapping("/students/{academyId}/add")
    public String addStudents(@PathVariable("academyId") Integer academyId, @RequestBody(required = false) MultiValueMap<String, String> formData) {
        if (formData != null) {
            List<Integer> userIds = parseData(formData);
            if (userIds.size() > 0) {
                studentService.addStudentsToAcademy(academyId, userIds);
            }
        }
        return "redirect:/students?academyId=" + academyId;
    }

    private List<Integer> parseData(MultiValueMap<String, String> formData) {
        List<Integer> userIds = new ArrayList<>();
        formData.forEach((key, value) -> {
            if (key != null && value.size() == 1 && value.contains("on")) {
                String[] arr = key.split("checked");
                userIds.add(Integer.parseInt(arr[1]));
            }
        });
        return userIds;
    }

    @PostMapping("/students/{academyId}")
    public String deleteStudents(@PathVariable("academyId") Integer academyId, @RequestBody(required = false) MultiValueMap<String, String> formData) {
        if (formData != null) {
            List<Integer> userIds = parseData(formData);
            if (userIds.size() > 0) {
                studentService.deleteStudentsFromAcademy(academyId, userIds);
            }
        }
        return "redirect:/students?academyId=" + academyId;
    }

}
