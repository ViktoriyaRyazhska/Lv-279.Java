package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Characteristic;
import ua.softserve.persistence.entity.Mark;

import java.util.List;

public interface MarkDAO extends JpaRepository<Mark, Integer> {
    List<Mark> findAllByCharacteristicId(int characteristicId);
}
