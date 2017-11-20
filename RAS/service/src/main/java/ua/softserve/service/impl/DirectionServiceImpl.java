package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.DirectionsDAO;
import ua.softserve.persistence.entity.Directions;
import ua.softserve.service.DirectionService;

import java.util.List;

@Service
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    private DirectionsDAO directionDao;

    @Transactional
    @Override
    public void save(Directions direction) {
        directionDao.save(direction);
    }

    @Transactional
    @Override
    public Directions findOne(int id) {
        return directionDao.findOne(id);
    }

    @Transactional
    @Override
    public List<Directions> findAll() {
        return directionDao.findAll();
    }

    @Transactional
    @Override
    public void remove(Directions direction) {
        directionDao.delete(direction);
    }
}
