package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.HistoryDAO;
import ua.softserve.persistence.entity.History;
import ua.softserve.service.HistoryService;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDAO historyDAO;
    @Transactional
    @Override
    public List<History> findByAcademyName( String name) {
        return historyDAO.findByAcademyName(name);
    }

    @Override
    public List<History> getAll() {
        return historyDAO.findAll();
    }
}
