/*
 * CheckListByGroupsDto
 *
 * Version 1.0-SNAPSHOT
 *
 * 30.11.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.service.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.softserve.persistence.entity.EnglishLevel;
import ua.softserve.persistence.entity.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

import static ua.softserve.persistence.constants.ConstantsFromDb.ENGLISH_LEVEL_PRE_INTERMEDIATE_ID;

@Getter
@Setter
@NoArgsConstructor
public class CheckListByGroupsDto {

    private String groupName;
    private String cityName;
    private String status;
    private String teachers;
    private String experts;
    private Map<String, Integer> r = new HashMap<>();
    private double total;

    private static String[][] KEYS = {
            { "englishLevelDefined", "englishLevelCorrect", "entryScoreDefined", "incomingTestDefined",
                    "approvedByDefined", "teacherDefined", "expertDefined" },
            { "test1", "test2", "test3", "test4", "test5", "intermediateTestBasePass", "intermediateTestLangPass",
                    "teacherFeedbacksFilledIn", "expertFeedbacksFilledIn" },
            { "finalTestBasePass", "finalTestLangPass", "interviewerDefined", "interviewerSummaryDefined",
                    "expertsLoadFilledIn", "interviewersLoadFilledIn" },
            { "test6", "test7", "test8", "test9", "test10", } };

    public void setTotal() {
        double sum = 0;
        for (Map.Entry s : r.entrySet()) {
            sum += (Integer) s.getValue();
        }
        total = (double) Math.round((sum / r.size()) * 100 * 100) / 100;

        int flag = 1;
        for (String s : KEYS[0]) {
            flag *= r.get(s);
        }
        r.put("groupStartedSuccessfully", flag);
        if (flag == 0) {
            r.put("groupReadyToOffering", 0);
            r.put("groupReadyForClose", 0);
        } else {
            flag = 1;
            for (String s : KEYS[1]) {
                flag *= r.get(s);
            }
            r.put("groupReadyToOffering", flag);
            if (flag == 0) {
                r.put("groupReadyToOffering", 0);
            } else {
                flag = 1;
                for (String s : KEYS[2]) {
                    flag *= r.get(s);
                }
                r.put("groupReadyForClose", flag);
            }
        }

    }

    public static final Map<String, Predicate<Student>> predicates;
    static {
        predicates = new HashMap<>();
        predicates.put("englishLevelDefined", student -> student.getData().getEnglishLevel() != null);
        predicates.put("englishLevelCorrect", student -> {
            EnglishLevel englishLevel = student.getData().getEnglishLevel();
            return englishLevel != null && englishLevel.getEnglishLevelId() >= ENGLISH_LEVEL_PRE_INTERMEDIATE_ID;
        });
        predicates.put("entryScoreDefined", student -> student.getData().getEntryScore() != null);
        predicates.put("incomingTestDefined", student -> student.getData().getIncomingTest() != null);
        predicates.put("approvedByDefined", student -> student.getApprovedBy() != null);
        predicates.put("intermediateTestBasePass", student -> student.getData().getIntermBase() != null);
        predicates.put("intermediateTestLangPass", student -> student.getData().getIntermLang() != null);
        predicates.put("teacherFeedbacksFilledIn",
                student -> student.getTeacherFeedback() != null && student.getData().getTeacherScore() != null);
        predicates.put("expertFeedbacksFilledIn",
                student -> student.getExpertFeedback() != null && student.getData().getExpertScore() != null);
        predicates.put("finalTestBasePass", student -> student.getData().getFinalBase() != null);
        predicates.put("finalTestLangPass", student -> student.getData().getFinalLang() != null);
        predicates.put("interviewerSummaryDefined", student -> student.getData().getInterviewerComment() != null);
        predicates.put("test1", student -> student.getData().getTestOne() != null);
        predicates.put("test2", student -> student.getData().getTestTwo() != null);
        predicates.put("test3", student -> student.getData().getTestThree() != null);
        predicates.put("test4", student -> student.getData().getTestFour() != null);
        predicates.put("test5", student -> student.getData().getTestFive() != null);
        predicates.put("test6", student -> student.getData().getTestSix() != null);
        predicates.put("test7", student -> student.getData().getTestSeven() != null);
        predicates.put("test8", student -> student.getData().getTestEight() != null);
        predicates.put("test9", student -> student.getData().getTestNine() != null);
        predicates.put("test10", student -> student.getData().getTestTen() != null);

    }

}
