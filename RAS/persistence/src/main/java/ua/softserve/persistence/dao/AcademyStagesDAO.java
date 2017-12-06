package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.AcademyStages;

import java.util.List;

public interface AcademyStagesDAO extends JpaRepository<AcademyStages, Integer> {
    List<AcademyStages> findAll();
}
