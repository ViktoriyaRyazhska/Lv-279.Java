package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.dao.LanguageTranslationsDAO;
import ua.softserve.persistence.entity.Language_Translations;
import ua.softserve.service.LanguageTranslationsService;

import java.util.List;

@Component
public class LanguageTranslationsServiceImpl implements LanguageTranslationsService {
    @Autowired
    LanguageTranslationsDAO languageTranslationsDAO;

    @Override
    public List<String> getTranslations() {
        return languageTranslationsDAO.getTranslations();
    }

    @Override
    public List<Language_Translations> getAllLanguageTranslationsName() {
        return languageTranslationsDAO.getAllLanguageTranslationsName();
    }


}
