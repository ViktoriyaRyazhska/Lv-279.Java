package ua.softserve.validator.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.exception.TimeFrameException;
import ua.softserve.service.impl.AcademyServiceImpl;
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
        notNull.and(notEmpty).test(academyDTO.getGrName()).throwIfInvalidData("Group Name");
        lessThan(MAX_LENGHT_OF_GROUP_NAME).test(academyDTO.getGrName()).throwIfInvalidData("Group Name");
        notNull.and(notEmpty).test(academyDTO.getNameForSite()).throwIfInvalidData("Name for Site");
        lessThan(MAX_LENGHT_OF_NAME_FOR_SITE).test(academyDTO.getNameForSite()).throwIfInvalidData("Name for Site");

        try {
            logger.info("Before startDateLessThanEndDate(academyDTO.getStartDate()).test(academyDTO.getEndDate())");
            startDateLessThanEndDate(academyDTO.getStartDate()).test(academyDTO.getEndDate()).throwIfInvalidTimeFrameException();
        } catch (TimeFrameException e) {
            logger.error("End date biggest than start date");
        }

        lowerThan(MAX_STUDENT_COUNT).and(greaterThan(MIN_STUDENT_COUNT)).test(academyDTO.getStudentPlannedToEnrollment()).throwIfInvalidData();
        lowerThan(MAX_STUDENT_COUNT).and(greaterThan(MIN_STUDENT_COUNT)).test(academyDTO.getStudentPlannedToGraduate()).throwIfInvalidData();
    }
}
