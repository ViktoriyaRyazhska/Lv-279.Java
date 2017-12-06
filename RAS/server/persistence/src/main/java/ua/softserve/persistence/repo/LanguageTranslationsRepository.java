package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.LanguageTranslations;

import java.util.List;

public interface LanguageTranslationsRepository extends JpaRepository<LanguageTranslations, Integer> {

    @Query(value = "select * from city join language_translations on city.city_id = language_translations.item_id where ita = 1 and tag like 'city' and local like 'en' group by trasnlation", nativeQuery = true)
    List<LanguageTranslations> getAllLanguageTranslationsName();

    @Query(value = "select lt from LanguageTranslations lt where lt.tag like 'city' and lt.local like 'en' and lt.itemId = :id")
    LanguageTranslations findById(@Param("id") int id);

    List<LanguageTranslations> findAllByItemId(int id);


}

