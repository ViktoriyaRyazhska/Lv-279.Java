package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@Entity
@Table(name = "academyStages")
public class AcademyStages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stage_id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "sort")
    private byte sort;

    public AcademyStages() {}
}
