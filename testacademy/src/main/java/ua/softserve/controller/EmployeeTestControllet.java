/*
* EmployeeTestControllet
*
* Version 1.0-SNAPSHOT
*
* 04.12.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.*;

import java.util.List;

@RestController
public class EmployeeTestControllet {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private GroupInfoRepository groupInfoRepository;
    @Autowired
    private GroupInfoTeachersRepository groupInfoTeachersRepository;
    @Autowired
    private TeacherTypesRepository teacherTypesRepository;
    @Autowired
    private AcademyRepository academyRepository;

    @GetMapping(name = "/doThis", produces = "application/json")
    public ResponseEntity<List<GroupInfoTeachers>> doThis() {
        Academy academy = academyRepository.findOne(1);
        List<GroupInfoTeachers> all =
                groupInfoTeachersRepository.findAllByAcademy_AcademyId(academy.getAcademyId());
        for (GroupInfoTeachers git : all) {
            System.out.println(git.getEmployee().getFirstNameEng());
            System.out.println(git.getEmployee().getLastNameEng());
            System.out.println(git.getTeacherType().getName());
        }
        return new ResponseEntity<>(all, HttpStatus.OK);
    }
}
