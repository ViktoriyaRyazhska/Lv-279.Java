package ua.softserve.service;

import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.dto.AcademyForViewDTO;

import java.util.List;
import java.util.Map;

public interface GroupInfoService {
    /*void save(GroupInfo groupInfo);

    // void saveCustom(int id,String role,int[] arr, EmployeeService employeeService);

    GroupInfo findOne(int id);

    GroupInfo findOneGroupInfoByAcademyId(int groupInfoId);

    Map<GroupInformationDTO, Integer> getInfoAboutStudents();

    List<GroupInfo> findAllWithOrder();

    List<GroupInformationDTO> findAllInfoAboutGroups();*/
    void save(GroupInfo groupInfo);

    // void saveCustom(int id,String role,int[] arr, EmployeeService employeeService);

    GroupInfo findOne(int id);

    GroupInfo findOneGroupInfoByAcademyId(int groupInfoId);

    List<AcademyForViewDTO> getAllAcademies();

    List<GroupInfo> findAllWithOrder();
}
