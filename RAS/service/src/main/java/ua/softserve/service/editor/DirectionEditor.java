package ua.softserve.service.editor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.entity.Directions;
import ua.softserve.service.DirectionService;

import java.beans.PropertyEditorSupport;

@Component
public class DirectionEditor extends PropertyEditorSupport {

    @Autowired
    DirectionService directionService;

    @Override
    public void setAsText(String direction_id) throws IllegalArgumentException {
        int directionId = Integer.parseInt(direction_id);
        Directions directions = directionService.findOne(directionId);
        setValue(directions);
    }
}
