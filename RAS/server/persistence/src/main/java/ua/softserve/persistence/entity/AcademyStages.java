package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@Entity
@Table(name = "academy_stages")
public class AcademyStages {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stage_id")
    private int stageId;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "sort")
    private byte sort;

    public AcademyStages() {}
}
