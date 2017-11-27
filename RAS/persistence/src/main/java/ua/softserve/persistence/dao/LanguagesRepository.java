package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Languages;

public interface LanguagesRepository extends JpaRepository<Languages, Integer> {
}
