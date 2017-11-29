package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.MarkDAO;
import ua.softserve.persistence.entity.Mark;
import ua.softserve.service.MarkService;

import java.util.List;

@Service
public class MarkServiceImpl implements MarkService {
    @Autowired
    private MarkDAO markDAO;

    @Transactional
    @Override
    public List<Mark> findAllByCharacteristicId(int characteristicId) {
       return markDAO.findAllByCharacteristicId(characteristicId);
    }

    @Transactional
    @Override
    public List<Mark> findAll() {
       return markDAO.findAll();
    }

    @Override
    public Mark findOne(int id) {
        return markDAO.findOne(id);
    }
}
