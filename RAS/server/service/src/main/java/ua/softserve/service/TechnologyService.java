package ua.softserve.service;

import ua.softserve.persistence.entity.Technologies;

import java.util.List;

public interface TechnologyService {
    void save(Technologies technologies);

    Technologies findOne(int id);

    List<Technologies> findAll();

    List<Technologies> findAllTechonologyInIta();

    void remove(Technologies technologies);
}
