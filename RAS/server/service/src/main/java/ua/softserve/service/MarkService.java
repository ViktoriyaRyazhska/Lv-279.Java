package ua.softserve.service;

import ua.softserve.persistence.entity.Mark;

import java.util.List;

public interface MarkService {
    List<Mark> findAll();
    List<Mark> findAllByCharacteristicId(int characteristicId);
}
