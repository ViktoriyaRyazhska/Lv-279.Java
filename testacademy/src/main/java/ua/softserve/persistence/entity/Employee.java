package ua.softserve.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employee_id;

    @NotNull
    @Column(name = "firstnameeng")
    private String firstnameeng;

    @NotNull
    @Column(name = "lastnameeng")
    private String lastnameeng;

    @NotNull
    @Column(name = "firstnameukr")
    private String firstnameukr;

    @NotNull
    @Column(name = "lastnameukr")
    private String lastnameukr;

    @NotNull
    @Column(name = "secondnameukr")
    private String secondnameukr;

    @ManyToMany(cascade =  CascadeType.MERGE,fetch = FetchType.LAZY)
    @JoinTable(name = "employee_teachertype",
        joinColumns = {@JoinColumn(name = "employee_id")},
        inverseJoinColumns = {@JoinColumn(name = "teachertype_id")})
    @JsonIgnore
    private List<TeacherTypes> teacherTypes;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "employees")
    @JsonIgnore
    private List<GroupInfo> groupInfosForTeachers;

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", firstnameeng='" + firstnameeng + '\'' +
                ", lastnameeng='" + lastnameeng + '\'' +
                ", firstnameukr='" + firstnameukr + '\'' +
                ", lastnameukr='" + lastnameukr + '\'' +
                ", secondnameukr='" + secondnameukr + '\'' +
                '}';
    }
}
