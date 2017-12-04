package ua.softserve.service;


import ua.softserve.persistence.entity.Academy;
import ua.softserve.service.dto.AcademyDTO;

import java.util.List;

public interface AcademyService {
    Academy getById(Integer id);

    void save(Academy user);

    void saveCustom(int id,String role,int[] arr, EmployeeService employeeService);

    Academy findOne(int id);

    List<AcademyDTO> findWithEmployeeExperts();

    AcademyDTO getAcademyDTO();

    List<Academy> getAllAcademys();

}
