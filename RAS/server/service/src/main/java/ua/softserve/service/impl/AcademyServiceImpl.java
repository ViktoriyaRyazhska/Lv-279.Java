package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.AcademyRepository;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.*;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.converter.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {
    private static final int MAXROW = 10;
    @Autowired
    AcademyRepository academyRepository;

    @Autowired
    AcademyConverter academyConverter;

    @Transactional(readOnly = true)
    @Override
    public Academy getById(Integer id) {
        return academyRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Academy> getAllAcademys() {
        return academyRepository.findAll();
    }

    @Transactional
    @Override
    public List<Academy> findAllByName(String name) {
        return academyRepository.findAllByName(name);
    }

    @Transactional
    @Override
    public void save(Academy academy) {
        academyRepository.save(academy);
    }

    @Transactional
    @Override
    public void saveDTO(AcademyDTO academyDTO) {
        academyRepository.save(academyConverter.toEntity(academyDTO));
    }

    @Transactional
    @Override
    public void saveCustom(int id, String role, int[] arr, EmployeeService employeeService) {
        List<Employee> employees;
        Academy academy;
        if (role.equals("Teacher")) {
            academy = academyRepository.findWithEmployeeTeacher(id);
            employees = academy.getTeachers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setTeachers(employees);
            academyRepository.save(academy);
        } else if (role.equals("Expert")) {
            academy = academyRepository.findWithEmployeeExperts(id);
            employees = academy.getExperts();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setExperts(employees);
            academyRepository.save(academy);
        } else if (role.equals("Interviewer")) {
            academy = academyRepository.findWithEmployeeInterviewers(id);
            employees = academy.getInterviewers();
            for (int i : arr) {
                if (!employees.contains(employeeService.findOne(i))) {
                    employees.add(employeeService.findOne(i));
                }
            }
            academy.setInterviewers(employees);
            academyRepository.save(academy);
        } else throw new IllegalArgumentException();
    }

    @Override
    public Academy findOne(int id) {
        return academyRepository.findOne(id);
    }

    @Override
    public Academy findWithEmployeeTeacher(int id) {
        return academyRepository.findWithEmployeeTeacher(id);
    }

    @Override
    public Academy findWithEmployeeExperts(int id) {
        return academyRepository.findWithEmployeeExperts(id);
    }

    @Override
    public Academy findWithEmployeeInterviewers(int id) {
        return academyRepository.findWithEmployeeInterviewers(id);
    }

    @Transactional
    @Override
    public List<AcademyDTO> findWithEmployeeExperts() {
        List<Academy> academies = academyRepository.findWithEmployeeExperts();
        List<AcademyDTO> academyDTOS = new ArrayList<>();
        for(Academy academy: academies){
            AcademyDTO academyDTO = academyConverter.toDTO(academy);
            academyDTOS.add(academyDTO);
        }
        return academyDTOS;
    }
}

