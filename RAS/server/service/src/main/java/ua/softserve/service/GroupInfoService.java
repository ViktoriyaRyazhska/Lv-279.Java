package ua.softserve.service;

import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.service.dto.AcademyDTO;

import java.util.List;

public interface GroupInfoService {
    void save(GroupInfo user);

//    void saveCustom(int id,String role,int[] arr, EmployeeService employeeService);

    GroupInfo findOne(int id);

    List<AcademyDTO> getAllAcademies();
}
