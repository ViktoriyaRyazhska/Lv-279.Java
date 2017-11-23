package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString
@Getter @Setter
@Entity
@Table(name = "student_group_count")
public class StudentGroupCount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "student_group_count_id")
    private int studentGroupCountId;

    @NotNull
    @Column(name = "students_planned_to_graduate")
    private int studentsPlannedToGraduate;

    @NotNull
    @Column(name = "students_planned_to_enrollment")
    private int studentsPlannedToEnrollment;

    @NotNull
    @Column(name = "students_actual")
    private int studentsActual;

    public StudentGroupCount() {}
}