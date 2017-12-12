package ua.softserve.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    @Embedded
    private StudentTestData data;

    @ManyToOne
    @JoinColumn(name = "student_status_id")
    private StudentStatuses studentStatus;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "teacher_student_feedback_id")
    private Feedback teacherFeedback = new Feedback();

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "expert_student_feedback_id")
    private Feedback expertFeedback = new Feedback();

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee approvedBy;

    @Column(columnDefinition = "tinyint")
    private boolean removed;

    public Student(Integer userId, Integer academyId) {
        this.user = new User();
        this.user.setId(userId);
        this.academy = new Academy();
        this.academy.setAcademyId(academyId);
    }

    public Student setApprovedBy(Employee employee) {
        approvedBy = employee;
        return this;
    }

    public Student unRemove() {
        removed = false;
        return this;
    }
}
