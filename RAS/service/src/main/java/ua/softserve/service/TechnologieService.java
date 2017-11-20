package ua.softserve.service;

import ua.softserve.persistence.entity.Technologies;

import java.util.List;

public interface TechnologieService {
    void save(Technologies user);

    Technologies findOne(int id);

    List<Technologies> findAll();

    void remove(Technologies user);
}
