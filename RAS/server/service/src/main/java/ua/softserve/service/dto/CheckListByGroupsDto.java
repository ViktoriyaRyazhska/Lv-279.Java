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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CheckListByGroupsDto {

    public enum TeacherTypes {
            TEACHER, EXPERT, INTERVIEWER;
    };
    private String groupName;
    private String cityName;
    private String status;
    private List<TeacherInGroup> teachers;
    private List<StudentInGroup> students;
    private Date startDate;
    private Date endDate;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class StudentInGroup {
        private String status;
        private String englishLevel;
        private Double entryScore;
        private TestsOfStudent testsOfStudent;
        private List<TeacherOfStudent> teachersOfStudent;
        private String approvedBy;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class TeacherInGroup {
        private String fullName;
        private double load;
        private TeacherTypes type;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class TeacherOfStudent {
        private List<String> enumeratedFeedbacks;
        private double score;
        private String summary;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public class TestsOfStudent {
        private double[] testN = new double[10];
        private double incomingTest;
        private double intermediateTestBase;
        private double intermediateTestLang;
        private double finalTestBase;
        private double finalTestLang;
    }

}
