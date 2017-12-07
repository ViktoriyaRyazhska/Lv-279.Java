package ua.softserve.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    @Column(name = "eng_gram")
    private Double engGram;

    @ManyToOne
    @JoinColumn(name = "english_level_id")
    private EnglishLevel englishLevel;

    @Column(name = "interm_test_base")
    private Double intermBase;

    @Column(name = "interm_test_lang")
    private Double intermLang;

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

    @Column(name = "final_base")
    private Double finalBase;

    @Column(name = "final_lang")
    private Double finalLang;

    @Column(name = "incoming_test")
    private Integer incomingTest;

    @Column(name = "teacher_score")
    private Double teacherScore;

    @Column(name = "expert_score")
    private Double expertScore;

    @Column(name = "interviewer_score")
    private Double interviewerScore;

    @ManyToOne
    @JoinColumn(name = "student_status_id")
    private StudentStatuses studentStatus;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "teacher_student_feedback_id")
    private Feedback teacherFeedback;

    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn(name = "expert_student_feedback_id")
    private Feedback expertFeedback;

    @Column(name = "interviewer_comment")
    private String interviewerComment;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee approvedBy;

    @Column(columnDefinition = "tinyint")
    private boolean removed;
}
