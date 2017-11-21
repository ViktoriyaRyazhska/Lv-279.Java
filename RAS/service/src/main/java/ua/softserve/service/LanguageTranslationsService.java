package ua.softserve.service;

import ua.softserve.persistence.entity.LanguageTranslations;
import java.util.List;

public interface LanguageTranslationsService {

    List<LanguageTranslations> getAllLanguageTranslationsName();
}
