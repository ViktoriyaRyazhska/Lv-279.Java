package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.TechnologiesDAO;
import ua.softserve.persistence.entity.Technologies;
import ua.softserve.service.TechnologieService;

import java.util.List;

@Service
public class TechnologieServiceImpl implements TechnologieService {

    @Autowired
    private TechnologiesDAO technologieDAO;

    @Transactional
    @Override
    public void save(Technologies technologies) {
        technologieDAO.save(technologies);
    }

    @Transactional
    @Override
    public Technologies findOne(int id) {
        return technologieDAO.findOne(id);
    }

    @Transactional
    @Override
    public List<Technologies> findAll() {
        return technologieDAO.findAll();
    }

    @Transactional
    @Override
    public void remove(Technologies technologies) {
        technologieDAO.delete(technologies);
    }
}
