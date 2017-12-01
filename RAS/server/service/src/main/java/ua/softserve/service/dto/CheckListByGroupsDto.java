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

    private String groupName;
    private String cityName;
    private String status;
    private List<FakeTeacher> teachers;
    private List<FakeExpert> experts;
    private List<Interviewer> interviewers;
    private List<FakeStudent> students;
    private Date startDate;
    private Date endDate;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class FakeStudent {
        private String status;
        private String englishLevel;
        private double[] testN = new double[10];
        private double intermediateTestBase;
        private double intermediateTestLang;
        private double finalTestBase;
        private double finalTestLang;
        private double entryScore;
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class FakeTeacher {
    }
// Entry score, Teachers Score, Expert Score
// Incoming test, Approved by,
// Teachers feedback – summary,
// Experts feedback – summary,
// Interviewers - summary
    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class FakeExpert {
    }

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    private class Interviewer {
    }
}
