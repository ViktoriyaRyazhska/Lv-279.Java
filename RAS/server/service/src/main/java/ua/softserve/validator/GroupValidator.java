package ua.softserve.validator;

import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.service.dto.AcademyForSaveDTO;

public interface GroupValidator {
        void validate(AcademyForSaveDTO academyForSaveDTO);
}