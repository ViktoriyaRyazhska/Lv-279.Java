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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

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

    private static String[] GROUP_STARTED_SUCCESS_FULLY_KEYS = {
            "englishLevelDefined",
            "englishLevelCorrect",
            "entryScoreDefined",
            "incomingTestDefined",
            "approvedByDefined",
            "teacherDefined",
            "expertDefined"
    };

    private static String[] GROUP_READY_TO_OFFERING_KEYS = {
            "tests1",
            "tests2",
            "tests3",
            "tests4",
            "tests5",
            "tests6",
            "tests7",
            "tests8",
            "tests9",
            "tests10",
            "intermediateTestBasePass",
            "intermediateTestLangPass",
            "teacherFeedbacksFilledIn",
            "expertFeedbacksFilledIn"
    };

    private static String[] GROUP_READY_FOR_CLOSE_KEYS = {
            "finalTestBasePass",
            "finalTestLangPass",
            "interviewerDefined",
            "interviewerSummaryDefined",
            "expertsLoadFilledIn",
            "interviewersLoadFilledIn"
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
        for (String s : GROUP_STARTED_SUCCESS_FULLY_KEYS) {
            flag *= r.get(s);
        }
        r.put("groupStartedSuccessfully", flag);
        if (flag == 0) {
            r.put("groupReadyToOffering", 0);
            r.put("groupReadyForClose", 0);
        } else {
            flag = 1;
            for (String s : GROUP_READY_TO_OFFERING_KEYS) {
                flag *= r.get(s);
            }
            r.put("groupReadyToOffering", flag);
            if (flag == 0) {
                r.put("groupReadyToOffering", 0);
            } else {
                flag = 1;
                for (String s : GROUP_READY_FOR_CLOSE_KEYS) {
                    flag *= r.get(s);
                }
                r.put("groupReadyForClose", flag);
            }
        }

    }
}
