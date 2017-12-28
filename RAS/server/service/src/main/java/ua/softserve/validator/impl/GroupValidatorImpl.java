package ua.softserve.validator.impl;


import ua.softserve.service.dto.AcademyForSaveDTO;
import ua.softserve.validator.GroupValidator;

import static ua.softserve.service.util.validations.helper.IntegerValidationHelpers.*;
import static ua.softserve.service.util.validations.helper.StringValidationHelpers.*;

public class GroupValidatorImpl implements GroupValidator {
    @Override
    public void validate(AcademyForSaveDTO academyForSaveDTO) {
        notNull.and(notEmpty).test(academyForSaveDTO.getGrName()).throwIfInvalidData();
        lessThan(50).or(moreThan(0)).test(academyForSaveDTO.getGrName()).throwIfInvalidData();
        notNull.and(notEmpty).test(academyForSaveDTO.getNameForSite()).throwIfInvalidData();
        lessThan(50).or(moreThan(0)).test(academyForSaveDTO.getNameForSite()).throwIfInvalidData();

        lowerThan(99).or(greaterThan(0)).test(academyForSaveDTO.getStudentPlannedToEnrollment()).throwIfInvalidData();
        lowerThan(99).or(greaterThan(0)).test(academyForSaveDTO.getStudentPlannedToGraduate()).throwIfInvalidData();
    }
}
