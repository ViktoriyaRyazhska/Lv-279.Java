package ua.softserve.service;

import ua.softserve.persistence.entity.Academy;
import ua.softserve.service.dto.AcademyDropDownLists;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.dto.GroupOverviewDropDownLists;

import java.util.List;

public interface AcademyService {

    Integer save(Academy academy);

    Academy findOne(int id);

    AcademyDropDownLists getAcademyDTO();

    GroupOverviewDropDownLists getGroupOverviewDTO();

    List<Academy> getAllAcademies();

    void saveAcademyAndGroupInfoFromAcademyDTO(AcademyDTO academyDTO);
}
