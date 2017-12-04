package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.AcademyStages;

import java.util.List;

public interface AcademyStagesRepository extends JpaRepository<AcademyStages, Integer> {
    List<AcademyStages> findAll();
}
