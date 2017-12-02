package ua.softserve.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "groupinfoteachers")
public class GroupInfoTeachers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int groupinfoteachers_id;

    @Column(name = "involved")
    private int involved;

    @Column(name = "contributedhours")
    private int contributedhours;

    @Column(name = "teachertype")
    private String teachertype;

    @Column(name = "employee_id")
    private int employee_id;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private GroupInfo groupInfo;

    public GroupInfoTeachers(int involved, int contributedhours, String teachertype, int employee_id, GroupInfo groupInfo) {
        this.involved = involved;
        this.contributedhours = contributedhours;
        this.teachertype = teachertype;
        this.employee_id = employee_id;
        this.groupInfo = groupInfo;
    }

    public GroupInfoTeachers() {
    }
}
