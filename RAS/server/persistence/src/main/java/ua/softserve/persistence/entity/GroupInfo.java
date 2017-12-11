package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "group_info")
public class GroupInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "group_info_id")
    private int groupInfoId;

    @OneToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    @NotNull
    @Column(name = "group_name")
    private String groupName;

    @NotNull
    @Column(name = "students_planned_to_graduate")
    private int studentsPlannedToGraduate;

    @NotNull
    @Column(name = "students_planned_to_enrollment")
    private int studentsPlannedToEnrollment;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private ProfileInfo profileInfo;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinTable(name = "group_tests",
//            joinColumns = @JoinColumn(name = "academy_id", referencedColumnName = "academy_id"),
//            inverseJoinColumns = @JoinColumn(name = "test_id",referencedColumnName = "id"))

//    @OneToMany
//    @JoinColumn(name = "academy_id", referencedColumnName = "academy_id")
//    private List<TestName> testNames;

    public GroupInfo() {
    }
}
