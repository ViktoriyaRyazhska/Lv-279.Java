package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.HistoryDAO;
import ua.softserve.persistence.dto.HistoryDTO;
import ua.softserve.persistence.entity.History;
import ua.softserve.service.HistoryService;

import java.util.ArrayList;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryDAO historyDAO;

    @Transactional
    @Override
    public List<History> findByAcademyName(String name) {
        return historyDAO.findByAcademyName(name);
    }

    @Transactional
    @Override
    public List<HistoryDTO> findAll() {
        List<HistoryDTO> historyDTOs = new ArrayList<>();
        List<History> histories = historyDAO.findAll();
        for (History history : histories) {
            HistoryDTO dto = new HistoryDTO();
            dto.setId(history.getId());
            dto.setAcademyName(history.getAcademyName());
            dto.setNameForSite(history.getNameForSite());
            dto.setLocation(history.getLocation());
            dto.setStage(history.getStage());
            dto.setDirection(history.getDirection());
            dto.setSartDate(history.getSartDate().toString().substring(0, 11));
            dto.setEndDate(history.getEndDate().toString().substring(0, 11));
            dto.setModifyDate(history.getModifyDate().toString().substring(0, 16));
            dto.setModifyBy(history.getModifyBy());
            dto.setCrmGroup(history.getCrmGroup());

            historyDTOs.add(dto);
        }
        return historyDTOs;
    }

}
