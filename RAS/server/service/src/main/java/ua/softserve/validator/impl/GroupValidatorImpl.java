package ua.softserve.validator;


import ua.softserve.persistence.entity.GroupInfo;

import static ua.softserve.validations.helper.IntegerValidationHelpers.*;
import static ua.softserve.validations.helper.StringValidationHelpers.*;

public class GroupValidatorImpl implements GroupValidator {
    @Override
    public void validate(GroupInfo groupInfo) {
        notNull.and(notEmpty).test(groupInfo.getGroupName()).throwIfInvalidData("can't be null or empty");
        notNull.and(notEmpty).test(groupInfo.getAcademy().getName()).throwIfInvalidData("can't be null or empty");

        lowerThan(0).or(greaterThan(99)).test(groupInfo.getStudentsPlannedToEnrollment()).throwIfInvalidData();
        lowerThan(0).or(greaterThan(99)).test(groupInfo.getStudentsPlannedToGraduate()).throwIfInvalidData();

    }
}
