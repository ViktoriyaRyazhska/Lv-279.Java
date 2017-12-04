package ua.softserve.controller;


import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.EmployeeRepository;
import ua.softserve.persistence.repo.GroupInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import ua.softserve.persistence.repo.GroupInfoTeachersRepository;

import java.util.List;


@RestController
public class AcademyController {
    @Autowired
    GroupInfoRepository groupInfoRepository;
    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    GroupInfoTeachersRepository groupInfoTeachersRepository;

    @RequestMapping(value = "/academy/addgroup",method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<GroupInfo> getAcademys() {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setGroupName("Lv-279");
//        groupInfo.setAcademy(new Academy());
//        groupInfo.setProfileInfo(new ProfileInfo());
        groupInfo.setStudentsPlannedToEnrollment(6);
        groupInfo.setStudentsPlannedToGraduate(5);
        groupInfoRepository.save(groupInfo);
        return new ResponseEntity<GroupInfo>(groupInfoRepository.findByAcademyAcademyId(0), HttpStatus.OK);
    }

//    @GetMapping("/olegtest")
//    public List<Employee> getSmth(){
//        int id=1;
//        GroupInfo groupInfo=groupInfoRepository.findWithEmployeeTeacher(id);
//        List<Employee> employees=groupInfo.getEmployees();
//        employees.add(employeeRepository.findOne(1));
//        groupInfoTeachersRepository.save(new GroupInfoTeachers(0,0,employeeRepository.findOne(1).getTeacherTypes().get(0).getName(),
//                1,groupInfo));
//        employees.add(employeeRepository.findOne(2));
//        groupInfoTeachersRepository.save(new GroupInfoTeachers(0,0,employeeRepository.findOne(2).getTeacherTypes().get(0).getName(),
//                2,groupInfo));
//        groupInfo.setEmployees(employees);
//        groupInfoRepository.save(groupInfo);
//
//        return null;
//    }

}

