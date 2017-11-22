package ua.softserve.service.editor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.entity.City;
import ua.softserve.persistence.entity.LanguageTranslations;
import ua.softserve.service.CityService;
import ua.softserve.service.LanguageTranslationsService;

import java.beans.PropertyEditorSupport;

@Component
public class CityEditor extends PropertyEditorSupport {

    @Autowired
    CityService cityService;

    @Override
    public void setAsText(String item_id) throws IllegalArgumentException {
        int itemId = Integer.parseInt(item_id);
        City city =  cityService.findOne(itemId);
        setValue(city);
    }
}

