package ua.softserve.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "testgroup")
public class TestGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int testgroup_id;

    @NotNull
    @Column(name = "name")
    private String name;

    @ManyToMany(cascade =  CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(
            name = "teacher_testgroup",
            joinColumns = {@JoinColumn(name = "testgroup_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private List<Employee> teachers;

    @ManyToMany(cascade =  CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(
            name = "expert_testgroup",
            joinColumns = {@JoinColumn(name = "testgroup_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private List<Employee> experts;

    @ManyToMany(cascade =  CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(
            name = "interviewer_testgroup",
            joinColumns = {@JoinColumn(name = "testgroup_id")},
            inverseJoinColumns = {@JoinColumn(name = "employee_id")}
    )
    private List<Employee> interviewers;

    @Override
    public String toString() {
        return "TestGroup{" +
                "testgroup_id=" + testgroup_id +
                ", name='" + name + '\'' +
                '}';
    }

    public TestGroup(String name, List<Employee> teachers) {
        this.name = name;
        this.teachers = teachers;
    }
}
