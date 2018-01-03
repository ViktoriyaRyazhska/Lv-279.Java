package ua.softserve.service;

import ua.softserve.persistence.entity.LanguageTranslations;

import java.util.List;
import java.util.Set;

public interface LanguageTranslationsService {

    Set<LanguageTranslations> getAllLanguageTranslationsName();

    void save(LanguageTranslations languageTranslations);

    LanguageTranslations findOne(int id);

    void remove(LanguageTranslations languageTranslations);
}
