package ua.softserve.persistence.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@ToString
@Getter
@Setter
@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int city_id;

    @NotNull
    @Column(name = "crm_id")
    private int crm_id;

    @Column(name = "country_id")
    private Integer country_id;

    @Column(name = "status")
    private Byte status;

    @Column(name = "ita")
    private Integer ita;

    @Column(name = "vacancy")
    private Integer vacancy;

    @Column(name = "state_id", columnDefinition = "INT(11) UNSIGNED")
    private Integer state_id;

    public City() {}

}
