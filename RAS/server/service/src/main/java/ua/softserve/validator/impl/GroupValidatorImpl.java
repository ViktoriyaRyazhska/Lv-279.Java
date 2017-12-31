package ua.softserve.validator.impl;


import ua.softserve.service.dto.AcademyForSaveDTO;
import ua.softserve.validator.GroupValidator;

import static ua.softserve.service.util.validations.helper.DateValidationHelpers.startDateLessThanEndDate;
import static ua.softserve.service.util.validations.helper.IntegerValidationHelpers.greaterThan;
import static ua.softserve.service.util.validations.helper.IntegerValidationHelpers.lowerThan;
import static ua.softserve.service.util.validations.helper.StringValidationHelpers.*;

public class GroupValidatorImpl implements GroupValidator {
    @Override
    public void validate(AcademyForSaveDTO academyForSaveDTO) {
        notNull.and(notEmpty).test(academyForSaveDTO.getGrName()).throwIfInvalidData("Group Name");
        lessThan(50).test(academyForSaveDTO.getGrName()).throwIfInvalidData("Group Name");
        notNull.and(notEmpty).test(academyForSaveDTO.getNameForSite()).throwIfInvalidData("Name for Site");
        lessThan(50).test(academyForSaveDTO.getNameForSite()).throwIfInvalidData("Name for Site");
        startDateLessThanEndDate(academyForSaveDTO.getStartDate()).test(academyForSaveDTO.getEndDate()).throwIfInvalidTimeFrameException();
        lowerThan(99).and(greaterThan(0)).test(academyForSaveDTO.getStudentPlannedToEnrollment()).throwIfInvalidData();
        lowerThan(99).and(greaterThan(0)).test(academyForSaveDTO.getStudentPlannedToGraduate()).throwIfInvalidData();
    }
}
