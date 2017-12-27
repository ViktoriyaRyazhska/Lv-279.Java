package ua.softserve.service;

import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.GroupInfo;

import java.util.List;

public interface GroupInfoService {
    void save(GroupInfo groupInfo);

    GroupInfo findOne(int id);

    List<GroupInformationDTO> getAllInformationAboutGroup();

    GroupInfo findOneGroupInfoByAcademyId(int academyId);
}
