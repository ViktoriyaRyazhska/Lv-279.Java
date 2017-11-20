package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Directions;

public interface DirectionsDAO extends JpaRepository<Directions, Integer> {
}
