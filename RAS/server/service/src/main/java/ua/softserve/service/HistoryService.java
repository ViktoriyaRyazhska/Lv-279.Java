package ua.softserve.service;

import ua.softserve.persistence.entity.History;

import java.util.List;

public interface HistoryService {
    List<History> findByAcademyId(int academyId);
    List<History> findAll();

}
