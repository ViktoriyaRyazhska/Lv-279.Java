package ua.softserve.service.dto.Impl;


import org.springframework.stereotype.Component;
import ua.softserve.service.dto.LanguageTranslationDTO;
import ua.softserve.persistence.entity.LanguageTranslations;

import java.util.HashMap;
import java.util.List;

@Component
public class LanguageTranslationDTOImpl implements LanguageTranslationDTO {
    private HashMap<Integer, String> cityMap;

    public LanguageTranslationDTOImpl() {
        cityMap = new HashMap<>();
    }

    public HashMap<Integer, String> getCityMap() {
        return cityMap;
    }

    public void setCityMap(HashMap<Integer, String> cityMap) {
        this.cityMap = cityMap;
    }

    public HashMap<Integer, String> convertListToHashMap(List<LanguageTranslations> languageTranslations){
        for(LanguageTranslations languageTranslation : languageTranslations){
            getCityMap().put(languageTranslation.getItemId(), languageTranslation.getTrasnlation());
        }
        return getCityMap();
    }
}
