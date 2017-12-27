package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.entity.LanguageTranslations;
import ua.softserve.persistence.repo.LanguageTranslationsRepository;
import ua.softserve.service.LanguageTranslationsService;

import java.util.List;
import java.util.Set;

@Component
public class LanguageTranslationsServiceImpl implements LanguageTranslationsService {
    @Autowired
    LanguageTranslationsRepository languageTranslationsRepository;

    @Override
    public Set<LanguageTranslations> getAllLanguageTranslationsName() {
        return languageTranslationsRepository.getAllLanguageTranslationsName();
    }

    @Override
    public void save(LanguageTranslations languageTranslations) {
        languageTranslationsRepository.save(languageTranslations);
    }

    @Override
    public LanguageTranslations findOne(int id) {
        return languageTranslationsRepository.findOne(id);
    }

    @Override
    public void remove(LanguageTranslations languageTranslations) {
        languageTranslationsRepository.delete(languageTranslations);
    }

}
