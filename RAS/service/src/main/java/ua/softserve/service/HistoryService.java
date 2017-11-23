package ua.softserve.service;

import ua.softserve.persistence.dto.HistoryDTO;
import ua.softserve.persistence.entity.History;

import java.util.List;

public interface HistoryService {
    List<History> findByAcademyName(String name);
    List<HistoryDTO> findAll();

}
