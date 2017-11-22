package ua.softserve.persistence.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "ssu_student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "student_id")
    private Integer studentId;

    @NotNull
    @OneToOne
    @JoinColumn(name = "group_direction_id")
    private ItaAcademy itaAcademy;

    @Column(name = "language")
    private Double language;

    @Column(name = "rate")
    private Double rate;

    @Column(name = "incoming_test")
    private Integer incomingTest;

    @Column(name = "entry_score")
    private Double entryScore;

    @Column(name = "test_1")
    private Double testOne;

    @Column(name = "test_2")
    private Double testTwo;

    @Column(name = "test_3")
    private Double testThree;

    @Column(name = "test_4")
    private Double testFour;

    @Column(name = "test_5")
    private Double testFive;

    @Column(name = "test_6")
    private Double testSix;

    @Column(name = "test_7")
    private Double testSeven;

    @Column(name = "test_8")
    private Double testEight;

    @Column(name = "test_9")
    private Double testNine;

    @Column(name = "test_10")
    private Double testTen;

    @Column(name = "base_test")
    private Double baseTest;

    @Column(name = "direction_test")
    private Double directionTest;

    @Column(name = "final_test")
    private Double finalTest;

    @Column(name = "teacher_score")
    private Double teacherScore;

    @Column(name = "teacher_comment")
    private String teacherComment;

    @Column(name = "expert_score")
    private Double expertScore;

    @Column(name = "expert_comment")
    private String expertComment;

    @Column(name = "interviewer_score")
    private Double interviewerScore;

    @Column(name = "interviewer_comment")
    private String interviewerComment;

    @Column(name = "teacher_student_feedback_id")
    private Feedback  teacherFeedback ;

    @Column(name = "expert_student_feedback_id")
    private Feedback  expertFeedback ;



}
