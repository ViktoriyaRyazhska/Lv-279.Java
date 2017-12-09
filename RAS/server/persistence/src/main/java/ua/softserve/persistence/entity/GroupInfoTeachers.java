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
@Table(name = "group_info_teachers")
public class GroupInfoTeachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    private Integer involved;

    @Column(name = "contributed_hours")
    private Integer contributedHours;

    @ManyToOne
    @JoinColumn(name = "teacher_type_id")
    private TeacherTypes teacherType;
}
