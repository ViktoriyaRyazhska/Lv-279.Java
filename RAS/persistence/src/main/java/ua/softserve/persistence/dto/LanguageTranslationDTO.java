package ua.softserve.persistence.dto;

import ua.softserve.persistence.entity.LanguageTranslations;

import java.util.HashMap;
import java.util.List;

/**
 * Created by shevt on 21.11.2017.
 */
public interface LanguageTranslationDTO {
    HashMap<Integer, String> convertListToHashMap(List<LanguageTranslations> languageTranslations);
}
