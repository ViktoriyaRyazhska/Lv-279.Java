package ua.softserve.validator.impl;


import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.validator.GroupValidator;

import static ua.softserve.service.util.validations.helper.DateValidationHelpers.startDateLessThanEndDate;
import static ua.softserve.service.util.validations.helper.IntegerValidationHelpers.greaterThan;
import static ua.softserve.service.util.validations.helper.IntegerValidationHelpers.lowerThan;
import static ua.softserve.service.util.validations.helper.StringValidationHelpers.*;

public class GroupValidatorImpl implements GroupValidator {
    @Override
    public void validate(AcademyDTO academyDTO) {
        notNull.and(notEmpty).test(academyDTO.getGrName()).throwIfInvalidData("Group Name");
        lessThan(50).test(academyDTO.getGrName()).throwIfInvalidData("Group Name");
        notNull.and(notEmpty).test(academyDTO.getNameForSite()).throwIfInvalidData("Name for Site");
        lessThan(50).test(academyDTO.getNameForSite()).throwIfInvalidData("Name for Site");
        startDateLessThanEndDate(academyDTO.getStartDate()).test(academyDTO.getEndDate()).throwIfInvalidTimeFrameException();
        lowerThan(99).and(greaterThan(0)).test(academyDTO.getStudentPlannedToEnrollment()).throwIfInvalidData();
        lowerThan(99).and(greaterThan(0)).test(academyDTO.getStudentPlannedToGraduate()).throwIfInvalidData();
    }
}
