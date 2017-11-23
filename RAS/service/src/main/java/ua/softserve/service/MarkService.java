package ua.softserve.service;

import ua.softserve.persistence.entity.Mark;

import java.util.List;

public interface MarkService {
    List<Mark> findAllByCharacteristicId(int characteristicId);
    List<Mark> findAll();
    Mark findOne(int id);
}
