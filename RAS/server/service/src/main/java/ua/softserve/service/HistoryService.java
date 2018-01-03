package ua.softserve.service;

import ua.softserve.persistence.entity.History;
import ua.softserve.service.dto.AcademyForSaveDTO;

import java.util.List;

public interface HistoryService {
    List<History> findByAcademyId(int academyId);
    List<History> findAll();
    void saveModifyby(Integer academyId);


}
