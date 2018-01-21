package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.EnglishLevel;

@Repository
public interface EnglishLevelRepository extends JpaRepository<EnglishLevel, Integer> {
}
