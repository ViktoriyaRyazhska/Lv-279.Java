package ua.softserve.service;

import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.service.dto.AcademyForSaveDTO;

import java.util.List;

public interface GroupInfoService {
    void save(GroupInfo groupInfo);

    GroupInfo findOne(int id);

    List<GroupInformationDTO> getAllInformationAboutGroup();

    GroupInfo findOneGroupInfoByAcademyId(int academyId);

    AcademyForSaveDTO getAcademyForSaveDTO(Integer groupId);
}
