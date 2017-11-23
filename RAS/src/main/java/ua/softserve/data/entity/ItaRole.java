package ua.softserve.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class ItaRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String emrole;
    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "itarole")
    @JsonIgnore
    private List<Employee> employees;

    public ItaRole() {
    }

    public ItaRole(String emrole, List<Employee> employees) {

        this.emrole = emrole;
        this.employees = employees;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmrole() {
        return emrole;
    }

    public void setEmrole(String emrole) {
        this.emrole = emrole;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "ItaRole{" +
                "id=" + id +
                ", emrole='" + emrole + '\'' +
                '}';
    }
}
