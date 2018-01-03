package ua.softserve.validator.impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.exception.TimeFrameException;
import ua.softserve.service.impl.AcademyServiceImpl;
import ua.softserve.validator.GroupValidator;

import static ua.softserve.service.util.validations.helper.DateValidationHelpers.startDateLessThanEndDate;
import static ua.softserve.service.util.validations.helper.IntegerValidationHelpers.greaterThan;
import static ua.softserve.service.util.validations.helper.IntegerValidationHelpers.lowerThan;
import static ua.softserve.service.util.validations.helper.StringValidationHelpers.*;

public class GroupValidatorImpl implements GroupValidator {
    private final Logger logger = LoggerFactory.getLogger(GroupValidatorImpl.class.getName());

    @Override
    public void validate(AcademyDTO academyDTO) {
        notNull.and(notEmpty).test(academyDTO.getGrName()).throwIfInvalidData("Group Name");
        lessThan(50).test(academyDTO.getGrName()).throwIfInvalidData("Group Name");
        notNull.and(notEmpty).test(academyDTO.getNameForSite()).throwIfInvalidData("Name for Site");
        lessThan(50).test(academyDTO.getNameForSite()).throwIfInvalidData("Name for Site");

        try {
            logger.info("Before startDateLessThanEndDate(academyDTO.getStartDate()).test(academyDTO.getEndDate())");
            startDateLessThanEndDate(academyDTO.getStartDate()).test(academyDTO.getEndDate()).throwIfInvalidTimeFrameException();
        } catch (TimeFrameException e) {
            logger.error("End date biggest than start date");
        }

        lowerThan(99).and(greaterThan(0)).test(academyDTO.getStudentPlannedToEnrollment()).throwIfInvalidData();
        lowerThan(99).and(greaterThan(0)).test(academyDTO.getStudentPlannedToGraduate()).throwIfInvalidData();
    }
}
