package ua.softserve.persistence.entity;

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
    @Column(name = "employee_id")
    private int employeeId;

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
}
