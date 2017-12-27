package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.LanguageTranslations;

import java.util.List;
import java.util.Set;

public interface LanguageTranslationsRepository extends JpaRepository<LanguageTranslations, Integer> {
    @Query(value = "select * from city join language_translations on city.city_id = language_translations.item_id where ita = 1 and tag = 'city' and local = 'en' order by trasnlation", nativeQuery = true)
    Set<LanguageTranslations> getAllLanguageTranslationsName();
}
