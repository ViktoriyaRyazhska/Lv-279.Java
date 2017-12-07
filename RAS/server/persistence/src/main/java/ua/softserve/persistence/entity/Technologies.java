package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Entity
@Table(name = "technologies")
public class Technologies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    private int technologyId;

    @NotNull
    @Column(name = "alias")
    private String alias;

    @NotNull
    @Column(name = "free")
    private int free;

    @NotNull
    @Column(name = "image")
    private String image;

    @NotNull
    @Column(name = "image2")
    private String image2;

    @Column(name = "ita")
    private Byte ita;

    @Column(name = "name")
    private String name;

    @Column(name = "directiond_id", columnDefinition = "INT(11) UNSIGNED")
    private int directiondId;

    public Technologies() {
    }
}
