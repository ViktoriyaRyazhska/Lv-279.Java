package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.AcademyDAO;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Directions;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.service.AcademyService;
import ua.softserve.service.EmployeeService;

import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {
    @Autowired
    private AcademyDAO academyDAO;

    @Transactional(readOnly = true)
    @Override
    public Academy getById(Integer id) {
        return academyDAO.findOne(id);
    }

    @Transactional
    @Override
    public List<Academy> getAllAcademys() {
        return academyDAO.findAll();
    }

    @Override
    public List<Academy> findAllByName(String name) {
        return academyDAO.findAllByName(name);
    }

    @Override
    public void save(Academy academy) {
        academyDAO.save(academy);
    }

    @Transactional
    @Override
    public void saveCustom(int id, String role, int[] arr, EmployeeService employeeService) {
        List<Employee> employees;
        Academy academy;
        if (role.equals("Teacher")){
            academy=academyDAO.findWithEmployeeTeacher(id);
            employees=academy.getTeachers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))){
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setTeachers(employees);
            academyDAO.save(academy);
        }
        else if (role.equals("Expert")){
            academy=academyDAO.findWithEmployeeExperts(id);
            employees=academy.getExperts();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setExperts(employees);
            academyDAO.save(academy);
        }
        else if (role.equals("Interviewer")){
            academy=academyDAO.findWithEmployeeInterviewers(id);
            employees=academy.getInterviewers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setInterviewers(employees);
            academyDAO.save(academy);
        }
        else throw new IllegalArgumentException();
    }

    @Override
    public Academy findOne(int id) {
        return academyDAO.findOne(id);
    }

    @Override
    public Academy findWithEmployeeTeacher(int id) {
        return academyDAO.findWithEmployeeTeacher(id);
    }

    @Override
    public Academy findWithEmployeeExperts(int id) {
        return academyDAO.findWithEmployeeExperts(id);
    }

    @Override
    public Academy findWithEmployeeInterviewers(int id) {
        return academyDAO.findWithEmployeeInterviewers(id);
    }
}
