package ua.softserve.validator.impl;


import ua.softserve.service.dto.AcademyForSaveDTO;
import ua.softserve.validator.GroupValidator;

import static ua.softserve.service.util.validations.helper.IntegerValidationHelpers.*;
import static ua.softserve.service.util.validations.helper.StringValidationHelpers.*;

public class GroupValidatorImpl implements GroupValidator {
    @Override
    public void validate(AcademyForSaveDTO academyForSaveDTO) {
        notNull.and(notEmpty).test(academyForSaveDTO.getGrName()).throwIfInvalidData("can't be null or empty");
        lessThan(0).or(moreThan(50)).test(academyForSaveDTO.getGrName()).throwIfInvalidData();
        notNull.and(notEmpty).test(academyForSaveDTO.getNameForSite()).throwIfInvalidData("can't be null or empty");
        lessThan(0).or(moreThan(50)).test(academyForSaveDTO.getNameForSite()).throwIfInvalidData();

        lowerThan(0).or(greaterThan(99)).test(academyForSaveDTO.getStudentPlannedToEnrollment()).throwIfInvalidData();
        lowerThan(0).or(greaterThan(99)).test(academyForSaveDTO.getStudentPlannedToGraduate()).throwIfInvalidData();
    }
}
