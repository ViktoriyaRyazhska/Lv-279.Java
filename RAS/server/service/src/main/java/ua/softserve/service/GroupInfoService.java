package ua.softserve.service;

import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.dto.AcademyForViewDTO;

import java.util.List;

public interface GroupInfoService {
    void save(GroupInfo groupInfo);

    // void saveCustom(int id,String role,int[] arr, EmployeeService employeeService);

    GroupInfo findOne(int id);

    GroupInfo findOneGroupInfoByAcademyId(int groupInfoId);

    List<AcademyForViewDTO> getAllAcademies();

    List<GroupInfo> findAllWithOrder();
}
