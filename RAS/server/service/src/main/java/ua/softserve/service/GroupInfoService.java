package ua.softserve.service;

import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.dto.AcademyForSaveDTO;
import ua.softserve.service.dto.AcademyForViewDTO;
import ua.softserve.service.dto.GroupAllInformationDTO;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface GroupInfoService {
    /*void save(GroupInfo groupInfo);

    // void saveCustom(int id,String role,int[] arr, EmployeeService employeeService);

    GroupInfo findOne(int id);

    GroupInfo findOneGroupInfoByAcademyId(int groupInfoId);

    Map<GroupInformationDTO, Integer> getInfoAboutStudents();

    Set<GroupAllInformationDTO> getAllInformationAboutGroup();

    public List<AcademyForViewDTO> getAllAcademies();

    List<GroupInfo> findAllWithOrder();

    List<GroupInformationDTO> findAllInfoAboutGroups();*/
    void save(GroupInfo groupInfo);

    // void saveCustom(int id,String role,int[] arr, EmployeeService employeeService);

    GroupInfo findOne(int id);

    List<GroupInformationDTO> getAllInformationAboutGroup();

    List<GroupInfo> findAllWithOrder();

    GroupInfo findOneGroupInfoByAcademyId(int academyId);

    AcademyForSaveDTO getAcademyForSaveDTO(Integer groupId);
}
