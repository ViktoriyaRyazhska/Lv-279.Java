package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.repo.HistoryRepository;
import ua.softserve.persistence.entity.History;
import ua.softserve.service.HistoryService;

import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryRepository historyDAO;

    @Transactional
    @Override
    public List<History> findByAcademyId(int academyId){
        return historyDAO.findByAcademyId(academyId);
    }

    @Transactional
    @Override
    public List<History> findAll() {
        return historyDAO.findAll();
    }

}
