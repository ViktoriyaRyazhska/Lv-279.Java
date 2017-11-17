package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Academy;

public interface AcadeTestJpa extends JpaRepository<Academy, Integer> {
}
