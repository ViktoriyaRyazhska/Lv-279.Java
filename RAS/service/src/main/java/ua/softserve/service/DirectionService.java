package ua.softserve.service;

import ua.softserve.persistence.entity.Directions;

import java.util.List;

public interface DirectionService {

    void save(Directions user);

    Directions findOne(int id);

    List<Directions> findAll();

    void remove(Directions user);
}
