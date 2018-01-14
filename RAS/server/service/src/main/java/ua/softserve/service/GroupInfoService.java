package ua.softserve.service;

import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.service.dto.AcademyDTO;

import java.util.List;

public interface GroupInfoService {
    void save(GroupInfo groupInfo);

    List<GroupInformationDTO> getAllInformationAboutGroup();

    GroupInfo findOneGroupInfoByAcademyId(Integer academyId);

    AcademyDTO getAcademyDTObyId(Integer groupId);
}
