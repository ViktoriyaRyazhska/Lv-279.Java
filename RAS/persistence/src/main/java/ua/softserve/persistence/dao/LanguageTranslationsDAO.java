package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.softserve.persistence.entity.LanguageTranslations;

import java.util.List;

public interface LanguageTranslationsDAO extends JpaRepository<LanguageTranslations, Integer> {

    @Query("select lt from LanguageTranslations lt where lt.tag like 'city' and lt.local like 'en'")
    List<LanguageTranslations> getAllLanguageTranslationsName();
}
