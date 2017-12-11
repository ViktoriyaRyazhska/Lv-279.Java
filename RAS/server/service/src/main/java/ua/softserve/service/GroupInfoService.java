package ua.softserve.service;

import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.entity.TestName;
import ua.softserve.service.dto.AcademyDTO;

import java.util.List;

public interface GroupInfoService {
    void save(GroupInfo groupInfo);

    // void saveCustom(int id,String role,int[] arr, EmployeeService employeeService);

    GroupInfo findOne(int id);

    GroupInfo findOneGroupInfoByAcademyId(int groupInfoId);

    List<AcademyDTO> getAllAcademies();

    List<GroupInfo> findAllWithOrder();

    List<TestName> findAllTestNamesByAcademyId (int groupId);

    void saveTestNames(List<TestName> testNames,Integer academy_id);
}
