package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.softserve.persistence.entity.LanguageTranslations;

import javax.persistence.NamedNativeQuery;
import java.util.List;

public interface LanguageTranslationsRepository extends JpaRepository<LanguageTranslations, Integer> {

    @Query("select lt from LanguageTranslations lt where lt.tag like 'city' and lt.local like 'en'")
    List<LanguageTranslations> getAllLanguageTranslationsName();

//    @Query("from city inner join language_translations on city.city_id = language_translations.item_id where ita = 1 and tag like 'city' and local like 'en' group by trasnlation")
//    List<LanguageTranslations> getAllLanguageTranslationsName();
}

