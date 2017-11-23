package ua.softserve.service.editor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.entity.Technologies;
import ua.softserve.service.TechnologieService;

import java.beans.PropertyEditorSupport;

@Component
public class TechnologieEditor extends PropertyEditorSupport {

    @Autowired
    TechnologieService technologieService;

    @Override
    public void setAsText(String technology_id) throws IllegalArgumentException {
        int technologyId = Integer.parseInt(technology_id);
        Technologies technologie = technologieService.findOne(technologyId);
        setValue(technologie);
    }
}

