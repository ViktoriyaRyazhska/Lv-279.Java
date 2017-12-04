package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Characteristic;

public interface CharacteristicDAO extends JpaRepository<Characteristic, Integer> {

}
