package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@Entity
@Table(name = "group_info")
public class GroupInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_info_id")
    private Integer groupInfoId;

    @OneToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    @NotNull
    @Column(name = "group_name")
    private String groupName;

    @NotNull
    @Column(name = "students_planned_to_graduate")
    private Integer studentsPlannedToGraduate;

    @NotNull
    @Column(name = "students_planned_to_enrollment")
    private Integer studentsPlannedToEnrollment;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileInfo profileInfo;

    public GroupInfo() {}
}
