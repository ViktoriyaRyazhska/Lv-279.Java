package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.TechnologiesRepository;
import ua.softserve.persistence.entity.Technologies;
import ua.softserve.service.TechnologieService;

import java.util.List;

@Service
public class TechnologieServiceImpl implements TechnologieService {

    @Autowired
    private TechnologiesRepository technologiesRepository;

    @Transactional
    @Override
    public void save(Technologies technologies) {
        technologiesRepository.save(technologies);
    }

    @Transactional
    @Override
    public Technologies findOne(int id) {
        return technologiesRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Technologies> findAll() {
        return technologiesRepository.findAll();
    }

    @Transactional
    @Override
    public void remove(Technologies technologies) {
        technologiesRepository.delete(technologies);
    }
}
