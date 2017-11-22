package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.TestGroupDAO;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.TestGroup;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.TestGroupService;

import java.util.Collection;
import java.util.List;

@Service
public class TestGroupServiceImpl implements TestGroupService{
    @Autowired
    private TestGroupDAO testGroupDAO;

    @Transactional
    @Override
    public void saveCustom(int id, String role, int[] arr, EmployeeService employeeService) {
        List<Employee> employees;
        TestGroup testGroup;
        if (role.equals("Teacher")){
            testGroup=testGroupDAO.findWithEmployeeTeacher(id);
            employees=testGroup.getTeachers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))){
                    employees.add(employeeService.findOne(i));
                }
            }
            testGroup.setTeachers(employees);
            testGroupDAO.save(testGroup);
        }
        else if (role.equals("Expert")){
            testGroup=testGroupDAO.findWithEmployeeExperts(id);
            employees=testGroup.getExperts();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            testGroup.setExperts(employees);
            testGroupDAO.save(testGroup);
        }
        else if (role.equals("Interviewer")){
            testGroup=testGroupDAO.findWithEmployeeInterviewers(id);
            employees=testGroup.getInterviewers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            testGroup.setInterviewers(employees);
            testGroupDAO.save(testGroup);
        }
        else throw new IllegalArgumentException();
    }

    @Override
    public TestGroup findOne(int id) {
        return testGroupDAO.findOne(id);
    }
}
