package ua.softserve.service;

import ua.softserve.persistence.entity.LanguageTranslations;
import java.util.List;

public interface LanguageTranslationsService {

    List<LanguageTranslations> getAllLanguageTranslationsName();

    void save(LanguageTranslations user);

    LanguageTranslations findOne(int id);

    void remove(LanguageTranslations user);
}
