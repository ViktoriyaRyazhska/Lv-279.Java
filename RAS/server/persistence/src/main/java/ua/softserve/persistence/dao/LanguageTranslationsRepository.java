package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.softserve.persistence.entity.LanguageTranslations;

import java.util.List;

public interface LanguageTranslationsRepository extends JpaRepository<LanguageTranslations, Integer> {

    @Query(value = "select * from city join language_translations on city.city_id = language_translations.item_id where ita = 1 and tag like 'city' and local like 'en' group by trasnlation", nativeQuery = true)
    List<LanguageTranslations> getAllLanguageTranslationsName();

    @Query("select lt from LanguageTranslations lt where lt.tag like 'city' and lt.local like 'en' and lt.itemId = ?1")
    LanguageTranslations findById(int id);
}

