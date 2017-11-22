package ua.softserve.service;


import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Directions;

import java.util.List;

public interface AcademyService {
    Academy getById(Integer id);

    List<Academy> getAllAcademys();

    List<Academy> findAllByName(String name);

    void save(Academy user);

    void saveCustom(int id,String role,int[] arr, EmployeeService employeeService);

    Academy findOne(int id);

    Academy findWithEmployeeTeacher(int id);

    Academy findWithEmployeeExperts(int id);

    Academy findWithEmployeeInterviewers(int id);

}
