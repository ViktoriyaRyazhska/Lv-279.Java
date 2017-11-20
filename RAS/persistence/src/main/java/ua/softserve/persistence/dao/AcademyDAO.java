package ua.softserve.persistence.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Academy;

import java.util.List;

public interface AcademyDAO extends JpaRepository<Academy, Integer> {
    List<Academy> findAllByName(String name);
}
