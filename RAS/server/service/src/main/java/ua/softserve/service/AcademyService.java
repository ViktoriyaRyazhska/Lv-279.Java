package ua.softserve.service;

import ua.softserve.persistence.entity.Academy;
import ua.softserve.service.dto.AcademyDropDownLists;
import ua.softserve.service.dto.AcademyForSaveDTO;

import java.util.List;

public interface AcademyService {

    Integer save(Academy academy);

    Academy findOne(int id);

    AcademyDropDownLists getAcademyDTO();

    List<Academy> getAllAcademies();

    void saveAcademyAndGroupInfoFromAcademyDTO(AcademyForSaveDTO academyDTO);
}
