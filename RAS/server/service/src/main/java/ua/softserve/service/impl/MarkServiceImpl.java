package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.repo.MarkRepository;
import ua.softserve.persistence.entity.Mark;
import ua.softserve.service.MarkService;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkRepository markRepository;

    @Transactional
    @Override
    public List<Mark> findAll() {
        return markRepository.findAll();
    }

    @Transactional
    @Override
    public List<Mark> findAllByCharacteristicId(int characteristicId) {
        return markRepository.findAllByCharacteristicId(characteristicId);
    }
}
