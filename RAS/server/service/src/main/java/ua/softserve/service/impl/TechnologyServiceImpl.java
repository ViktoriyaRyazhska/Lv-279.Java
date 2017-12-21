package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Technologies;
import ua.softserve.persistence.repo.TechnologiesRepository;
import ua.softserve.service.TechnologyService;

import java.util.List;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologiesRepository technologiesRepository;

    @Transactional
    @Override
    public void save(Technologies technologies) {
        technologiesRepository.save(technologies);
    }

    @Override
    public Technologies findOne(int id) {
        return technologiesRepository.findOne(id);
    }

    @Override
    public List<Technologies> findAll() {
        return technologiesRepository.findAll();
    }

    @Override
    public List<Technologies> findAllTechonologyInIta() {
        return technologiesRepository.findAllTechonologyInIta();
    }

    @Transactional
    @Override
    public void remove(Technologies technologies) {
        technologiesRepository.delete(technologies);
    }
}
