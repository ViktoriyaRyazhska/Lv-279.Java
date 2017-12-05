package ua.softserve.service.editor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.softserve.persistence.entity.Mark;
import ua.softserve.service.MarkService;

import java.beans.PropertyEditorSupport;

@Component
public class MarkEditor extends PropertyEditorSupport{
    @Autowired
    MarkService markService;

    @Override
    public void setAsText(String markId) throws IllegalArgumentException {
//        int id = Integer.parseInt(markId);
//        Mark mark = markService.findOne(id);
//        setValue(mark);
    }
}
