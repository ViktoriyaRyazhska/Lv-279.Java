package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Mark;
import ua.softserve.persistence.repo.MarkRepository;
import ua.softserve.service.MarkService;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {

    @Autowired
    private MarkRepository markRepository;

    /**
     * Get list of all Marks
     *
     * @return list of Marks
     */
    @Override
    public List<Mark> findAll() {
        return markRepository.findAll();
    }
}
