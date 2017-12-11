package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Directions;
import ua.softserve.persistence.repo.DirectionsRepository;
import ua.softserve.service.DirectionService;

import java.util.List;

@Service
public class DirectionServiceImpl implements DirectionService {

    @Autowired
    private DirectionsRepository directionsRepository;

    @Transactional
    @Override
    public void save(Directions direction) {
        directionsRepository.save(direction);
    }

    @Transactional
    @Override
    public Directions findOne(int id) {
        return directionsRepository.findOne(id);
    }

    @Transactional
    @Override
    public List<Directions> findAll() {
        return directionsRepository.findAll();
    }

    @Override
    public List<Directions> findAllDirectionsInIta() {
        return directionsRepository.findAllDirectionsInIta();
    }

    @Override
    public List<String> findDirectionsName() {
        return directionsRepository.findDirectionsName();
    }

    @Transactional
    @Override
    public void remove(Directions direction) {
        directionsRepository.delete(direction);
    }
}
