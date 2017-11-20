package ua.softserve.service;

import ua.softserve.persistence.entity.Language_Translations;

import java.util.List;

public interface LanguageTranslationsService {
    List<String> getTranslations();

    List<Language_Translations> getAllLanguageTranslationsName();
}
