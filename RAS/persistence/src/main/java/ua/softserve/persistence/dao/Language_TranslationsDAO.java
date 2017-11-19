package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Language_Translations;

public interface Language_TranslationsDAO extends JpaRepository<Language_Translations, Integer> {
}
