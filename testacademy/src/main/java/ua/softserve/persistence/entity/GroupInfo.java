package ua.softserve.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

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

    @ManyToMany(cascade =  CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(
            name = "employee_groupinfo",
            joinColumns = {@JoinColumn(name = "groupInfoId")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    @JsonIgnore
    private List<Employee> employees;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "groupInfo")
    @JsonIgnore
    private List<GroupInfoTeachers> groupInfoTeachers;



    public GroupInfo() {}

    @Override
    public String toString() {
        return "GroupInfo{" +
                "groupInfoId=" + groupInfoId +
                ", academy=" + academy +
                ", groupName='" + groupName + '\'' +
                ", studentsPlannedToGraduate=" + studentsPlannedToGraduate +
                ", studentsPlannedToEnrollment=" + studentsPlannedToEnrollment +
                ", profileInfo=" + profileInfo +
                '}';
    }
}
