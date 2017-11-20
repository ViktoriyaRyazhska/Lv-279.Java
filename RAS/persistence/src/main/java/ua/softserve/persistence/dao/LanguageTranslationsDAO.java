package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.softserve.persistence.entity.Language_Translations;

import java.util.List;

public interface LanguageTranslationsDAO extends JpaRepository<Language_Translations, Integer> {

    @Query("select lt from Language_Translations lt where lt.tag like 'city' and lt.local like 'en'")
    List<Language_Translations> getAllLanguageTranslationsName();

    @Query("select lt.trasnlation from Language_Translations lt where lt.tag like 'city' and lt.local like 'en'")
    List<String> getTranslations();
}
