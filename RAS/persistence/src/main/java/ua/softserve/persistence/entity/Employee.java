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
    @Column(name = "firstname")
    private String firstname;

    @NotNull
    @Column(name = "lastname")
    private String lastname;

    @NotNull
    @Column(name = "ukrfullname")
    private String ukrfullname;

    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private ItaRole itarole;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "teachers")
    private List<TestGroup> testGroupList1;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "experts")
    private List<TestGroup> testGroupList2;

    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "interviewers")
    private List<TestGroup> testGroupList3;

    @Override
    public String toString() {
        return "Employee{" +
                "employee_id=" + employee_id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", ukrfullname='" + ukrfullname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (employee_id != employee.employee_id) return false;
        return firstname != null ? firstname.equals(employee.firstname) : employee.firstname == null;
    }

    @Override
    public int hashCode() {
        int result = employee_id;
        result = 31 * result + (firstname != null ? firstname.hashCode() : 0);
        return result;
    }
}
