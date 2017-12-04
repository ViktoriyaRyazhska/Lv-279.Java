package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Mark;

import java.util.List;

public interface MarkDAO extends JpaRepository<Mark, Integer> {
    List<Mark> findAllByCharacteristicId(int characteristicId);
}
