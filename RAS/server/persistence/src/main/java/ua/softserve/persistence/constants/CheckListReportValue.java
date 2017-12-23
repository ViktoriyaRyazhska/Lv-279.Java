/*
 * Key
 *
 * Version 1.0-SNAPSHOT
 *
 * 22.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.persistence.constants;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Enum of names of values for Check List By Groups Report.
 * Values belong to particular category.
 */
public enum CheckListReportValue {
    groupName(CheckListReportCategory.NO_CATEGORY),
    cityName(CheckListReportCategory.NO_CATEGORY),
    status(CheckListReportCategory.NO_CATEGORY),
    teachers(CheckListReportCategory.NO_CATEGORY),
    experts(CheckListReportCategory.NO_CATEGORY),
    ENGLISH_LEVEL_DEFINED(CheckListReportCategory.GROUP_STARTED_SUCCESSFULLY),
    ENGLISH_LEVEL_CORRECT(CheckListReportCategory.GROUP_STARTED_SUCCESSFULLY),
    ENTRY_SCORE_DEFINED(CheckListReportCategory.GROUP_STARTED_SUCCESSFULLY),
    INCOMING_TEST_DEFINED(CheckListReportCategory.GROUP_STARTED_SUCCESSFULLY),
    APPROVED_BY_DEFINED(CheckListReportCategory.GROUP_STARTED_SUCCESSFULLY),
    TEACHER_DEFINED(CheckListReportCategory.GROUP_STARTED_SUCCESSFULLY),
    EXPERT_DEFINED(CheckListReportCategory.GROUP_STARTED_SUCCESSFULLY),

    TEST1(CheckListReportCategory.GROUP_READY_TO_OFFERING),
    TEST2(CheckListReportCategory.GROUP_READY_TO_OFFERING),
    TEST3(CheckListReportCategory.GROUP_READY_TO_OFFERING),
    TEST4(CheckListReportCategory.GROUP_READY_TO_OFFERING),
    TEST5(CheckListReportCategory.GROUP_READY_TO_OFFERING),
    INTERMEDIATE_TEST_BASE_PASS(CheckListReportCategory.GROUP_READY_TO_OFFERING),
    INTERMEDIATE_TEST_LANG_PASS(CheckListReportCategory.GROUP_READY_TO_OFFERING),
    TEACHER_FEEDBACKS_FILLED_IN(CheckListReportCategory.GROUP_READY_TO_OFFERING),
    EXPERT_FEEDBACKS_FILLED_IN(CheckListReportCategory.GROUP_READY_TO_OFFERING),

    FINAL_TEST_BASE_PASS(CheckListReportCategory.GROUP_READY_FOR_CLOSE),
    FINAL_TEST_LANG_PASS(CheckListReportCategory.GROUP_READY_FOR_CLOSE),
    INTERVIEWER_DEFINED(CheckListReportCategory.GROUP_READY_FOR_CLOSE),
    INTERVIEWER_SUMMARY_DEFINED(CheckListReportCategory.GROUP_READY_FOR_CLOSE),
    EXPERTS_LOAD_FILLED_IN(CheckListReportCategory.GROUP_READY_FOR_CLOSE),
    INTERVIEWERS_LOAD_FILLED_IN(CheckListReportCategory.GROUP_READY_FOR_CLOSE),

    TEST6(CheckListReportCategory.NO_CATEGORY),
    TEST7(CheckListReportCategory.NO_CATEGORY),
    TEST8(CheckListReportCategory.NO_CATEGORY),
    TEST9(CheckListReportCategory.NO_CATEGORY),
    TEST10(CheckListReportCategory.NO_CATEGORY);

    private CheckListReportCategory checkListReportCategory;

    CheckListReportValue(CheckListReportCategory checkListReportCategory) {
        this.checkListReportCategory = checkListReportCategory;
    }

    public static List<CheckListReportValue> getByCategory(CheckListReportCategory category) {
        return Arrays
                .stream(values())
                .filter(value -> value.checkListReportCategory == category)
                .collect(Collectors.toList());
    }
}
