package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Characteristic;

public interface CharacteristicRepository extends JpaRepository<Characteristic, Integer> {

}
