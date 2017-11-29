package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Technologies;

public interface TechnologiesRepository extends JpaRepository<Technologies, Integer> {
}
