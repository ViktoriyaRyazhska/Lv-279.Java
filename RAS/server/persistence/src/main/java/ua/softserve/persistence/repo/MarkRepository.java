package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Mark;

import java.util.List;

public interface MarkRepository extends JpaRepository<Mark, Integer> {
    List<Mark> findAll();

    List<Mark> findAllByCharacteristicId(int characteristicId);
}
