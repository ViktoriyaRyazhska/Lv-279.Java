package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.History;
import ua.softserve.persistence.entity.LoginUser;
import ua.softserve.persistence.repo.HistoryRepository;
import ua.softserve.service.HistoryService;
import ua.softserve.service.dto.AcademyForSaveDTO;

import java.util.List;
import java.util.Optional;

@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    private HistoryRepository historyRepository;

    @Override
    public List<History> findByAcademyId(int academyId) {
        return historyRepository.findByAcademyId(academyId);
    }

    @Override
    public List<History> findAll() {
        return historyRepository.findAll();
    }

    @Override
    public void saveModifyby(Integer academyId) {
        String modifyBy = ((Optional<LoginUser>) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).get().getUsername();
        historyRepository.addModifyBy(modifyBy,academyId);

    }


}
