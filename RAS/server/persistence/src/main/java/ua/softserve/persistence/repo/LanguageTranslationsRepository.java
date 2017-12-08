package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.LanguageTranslations;

import java.util.List;

public interface LanguageTranslationsRepository extends JpaRepository<LanguageTranslations, Integer> {

    @Query(value = "select * from city join language_translations on city.city_id = language_translations.item_id where ita = 1 and tag like 'city' and local like 'en' order by trasnlation", nativeQuery = true)
    List<LanguageTranslations> getAllLanguageTranslationsName();

    @Query(value = "select lt from LanguageTranslations lt where lt.tag like 'city' and lt.local like 'en'")
    List<LanguageTranslations> findAllCities();

    List<LanguageTranslations> findAllByItemId(int id);

    LanguageTranslations findByItemIdAndLanguageLanguageIdAndTag(int itemId, int langId, String tag);

    @Query(value = "select trasnlation from language_translations lt where tag like 'city' and local like 'en' AND item_id = :itemId", nativeQuery = true)
    String getOneCityNameTranslationByItemId(@Param(value = "itemId") int itemId);

}