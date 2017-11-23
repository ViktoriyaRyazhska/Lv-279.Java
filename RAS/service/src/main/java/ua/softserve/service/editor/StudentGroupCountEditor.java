package ua.softserve.service.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.entity.StudentGroupCount;
import ua.softserve.service.StudentGroupCountService;

import java.beans.PropertyEditorSupport;


@Component
public class StudentGroupCountEditor extends PropertyEditorSupport {

    @Autowired
    StudentGroupCountService studentGroupCountService;

    @Override
    public void setAsText(String id) throws IllegalArgumentException {
        int stageId = Integer.parseInt(id);
        StudentGroupCount studentGroupCount = new StudentGroupCount();
        setValue(studentGroupCount);
    }
}

