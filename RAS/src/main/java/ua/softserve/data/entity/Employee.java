package ua.softserve.data.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String firstname;
    private String lastname;
    private String uskfullname;
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JsonIgnore
    private ItaRole itarole;

    public Employee() {
    }

    public Employee(String firstname) {
        this.firstname = firstname;
    }

    public Employee(String firstname, ItaRole itarole) {
        this.firstname = firstname;
        this.itarole = itarole;
    }

    public Employee(String firstname, String lastname, String uskfullname, ItaRole itarole) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.uskfullname = uskfullname;
        this.itarole = itarole;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUskfullname() {
        return uskfullname;
    }

    public void setUskfullname(String uskfullname) {
        this.uskfullname = uskfullname;
    }

    public ItaRole getItarole() {
        return itarole;
    }

    public void setItarole(ItaRole itarole) {
        this.itarole = itarole;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", uskfullname='" + uskfullname + '\'' +
                '}';
    }
}
