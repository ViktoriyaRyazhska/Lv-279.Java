package ua.softserve.persistence.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @NotNull
    @Column(name = "first_name_eng")
    private String firstNameEng;

    @NotNull
    @Column(name = "last_name_eng")
    private String lastNameEng;

    @Column(name = "first_name_ukr")
    private String firstNameUkr;

    @Column(name = "last_name_ukr")
    private String lastNameUkr;

    @Column(name = "second_name_ukr")
    private String secondNameUkr;

    @OneToOne(mappedBy = "employee", fetch = FetchType.LAZY)
    @JsonIgnore
    private LoginUser loginUser;

    public Employee(Integer employeeId) {
        this.employeeId = employeeId;
    }
}
