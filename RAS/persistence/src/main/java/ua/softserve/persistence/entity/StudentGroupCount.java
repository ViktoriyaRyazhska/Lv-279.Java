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
    @GeneratedValue
    @Column(name = "student_group_count_id")
    private int student_group_count_id;

    @NotNull
    @Column(name = "students_planned_to_graduate")
    private int students_planned_to_graduate;

    @NotNull
    @Column(name = "students_planned_to_enrollment")
    private int students_planned_to_enrollment;

    @NotNull
    @Column(name = "students_actual")
    private int students_actual;

    public StudentGroupCount() {}
}