package ua.softserve.persistence.entity.views;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "check_list_report")
public class CheckListReport {

    @Id
    @Column(name = "academy_id")
    private Integer academyId;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "city_name")
    private String cityName;

    @Column(name = "status")
    private String status;

    @Column(name = "teachers")
    private String teachers;

    @Column(name = "experts")
    private String experts;

    @Column(name = "english_level")
    private Integer englishLevel;

    @Column(name = "english_level_correct")
    private Integer englishLevelCorrect;

    @Column(name = "entry_score")
    private Integer entryScore;

    @Column(name = "incoming_test")
    private Integer incomingTest;

    @Column(name = "approved_by")
    private Integer approvedBy;

    @Column(name = "teachers_assigned")
    private Integer teachersAssigned;

    @Column(name = "experts_assigned")
    private Integer expertsAssigned;

    @Column(name = "interviewers_assigned")
    private Integer interviewersAssigned;

    @Column(name = "test_1")
    private Integer test1;

    @Column(name = "test_2")
    private Integer test2;

    @Column(name = "test_3")
    private Integer test3;

    @Column(name = "test_4")
    private Integer test4;

    @Column(name = "test_5")
    private Integer test5;

    @Column(name = "test_6")
    private Integer test6;

    @Column(name = "test_7")
    private Integer test7;

    @Column(name = "test_8")
    private Integer test8;

    @Column(name = "test_9")
    private Integer test9;

    @Column(name = "test_10")
    private Integer test10;

    @Column(name = "interm_test_base")
    private Integer intermTestBase;

    @Column(name = "interm_test_lang")
    private Integer intermTestLang;

    @Column(name = "teacher_feedback")
    private Integer teacherFeedback;

    @Column(name = "expert_feedback")
    private Integer expertFeedback;

    @Column(name = "final_base")
    private Integer finalBase;

    @Column(name = "final_lang")
    private Integer finalLang;

    @Column(name = "interviewer_summary")
    private Integer interviewerSummary;

    @Column(name = "experts_load")
    private Integer expertsLoad;

    @Column(name = "interviewer_load")
    private Integer interviewerLoad;

    @Column(name = "group_started_successfuly")
    private Integer groupStartedSuccessfuly;

    @Column(name = "group_ready_to_offering")
    private Integer groupReadyToOffering;

    @Column(name = "group_ready_for_close")
    private Integer groupReadyForClose;

    @Column(name = "total")
    private Double total;
}
