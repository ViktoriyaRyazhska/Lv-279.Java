package ua.softserve.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.dao.LanguageTranslationsDAO;
import ua.softserve.persistence.entity.LanguageTranslations;

import java.util.List;

@Component
public class LanguageTranslationsServiceImpl implements LanguageTranslationsService {
    @Autowired
    LanguageTranslationsDAO languageTranslationsDAO;

    @Override
    public List<LanguageTranslations> getAllLanguageTranslationsName() {
        return languageTranslationsDAO.getAllLanguageTranslationsName();
    }

    @Override
    public void save(LanguageTranslations languageTranslations) {
        languageTranslationsDAO.save(languageTranslations);
    }

    @Override
    public LanguageTranslations findOne(int id) {
        return languageTranslationsDAO.findOne(id);
    }

    @Override
    public void remove(LanguageTranslations languageTranslations) {
        languageTranslationsDAO.delete(languageTranslations);
    }


}
