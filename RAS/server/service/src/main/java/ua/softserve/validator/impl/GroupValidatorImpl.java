package ua.softserve.validator.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.validator.GroupValidator;

import static ua.softserve.service.constans.ServiceConstans.*;
import static ua.softserve.service.util.validations.helper.DateValidationHelpers.startDateLessThanEndDate;
import static ua.softserve.service.util.validations.helper.IntegerValidationHelpers.greaterThan;
import static ua.softserve.service.util.validations.helper.IntegerValidationHelpers.lowerThan;
import static ua.softserve.service.util.validations.helper.StringValidationHelpers.*;

public class GroupValidatorImpl implements GroupValidator {
    private final Logger logger = LoggerFactory.getLogger(GroupValidatorImpl.class.getName());

    @Override
    public void validate(AcademyDTO academyDTO) {
        notNull.and(notEmpty).and(lessThan(MAX_LENGHT_OF_GROUP_NAME)).test(academyDTO.getGrName()).throwIfInvalidData("Group Name");
        notNull.and(notEmpty).and(lessThan(MAX_LENGHT_OF_NAME_FOR_SITE)).test(academyDTO.getNameForSite()).throwIfInvalidData("Name for Site");
        startDateLessThanEndDate(academyDTO.getStartDate()).test(academyDTO.getEndDate()).throwIfInvalidTimeFrameException();
        lowerThan(MAX_STUDENT_COUNT).and(greaterThan(MIN_STUDENT_COUNT)).test(academyDTO.getStudentPlannedToEnrollment()).throwIfInvalidData("Student planned to enrollment");
        lowerThan(MAX_STUDENT_COUNT).and(greaterThan(MIN_STUDENT_COUNT)).test(academyDTO.getStudentPlannedToGraduate()).throwIfInvalidData("Student planned to graduate");
    }
}
