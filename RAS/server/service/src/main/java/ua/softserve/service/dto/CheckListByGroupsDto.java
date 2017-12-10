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
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;

import static ua.softserve.persistence.constants.ConstantsFromDb.EL_PRE_INTERMEDIATE_ID;

@Getter
@Setter
@NoArgsConstructor
public class CheckListByGroupsDto {

    private String groupName;
    private String cityName;
    private String status;
    private List<TeacherInGroup> teachers;
    private Map<String, Integer> r = new HashMap<>();
    private double total;

    private static String[][] KEYS = {
            {
                    "englishLevelDefined",
                    "englishLevelCorrect",
                    "entryScoreDefined",
                    "incomingTestDefined",
                    "approvedByDefined",
                    "teacherDefined",
                    "expertDefined"
            },
            {
                    "test1",
                    "test2",
                    "test3",
                    "test4",
                    "test5",
                    "intermediateTestBasePass",
                    "intermediateTestLangPass",
                    "teacherFeedbacksFilledIn",
                    "expertFeedbacksFilledIn"
            },
            {
                    "finalTestBasePass",
                    "finalTestLangPass",
                    "interviewerDefined",
                    "interviewerSummaryDefined",
                    "expertsLoadFilledIn",
                    "interviewersLoadFilledIn"
            },
            {
                    "test6",
                    "test7",
                    "test8",
                    "test9",
                    "test10",
            }
    };

    @Getter
    @Setter
    @NoArgsConstructor
    public class TeacherInGroup {
        private String fullName;
        private String teacherType;
    }

    public void setTotal() {
        double sum = 0;
        for (Map.Entry s : r.entrySet()) {
            sum += (Integer) s.getValue();
        }
        System.out.println(r.size());
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

}
