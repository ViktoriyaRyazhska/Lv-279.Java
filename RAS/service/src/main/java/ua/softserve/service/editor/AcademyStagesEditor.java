/*
* AddGroupDTOEditor
*
* Version 1.0-SNAPSHOT
*
* 21.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.service.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.entity.AcademyStages;
import ua.softserve.service.AcademyStagesService;

import java.beans.PropertyEditorSupport;

@Component
public class AcademyStagesEditor extends PropertyEditorSupport {

    @Autowired
    AcademyStagesService asService;

    @Override
    public void setAsText(String stage_id) throws IllegalArgumentException {
        int stageId = Integer.parseInt(stage_id);
        AcademyStages academyStage = asService.findOne(stageId);
        setValue(academyStage);
    }
}
