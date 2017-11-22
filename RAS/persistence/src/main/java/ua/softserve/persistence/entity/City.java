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
    @JoinColumn(name = "crm_Id", foreignKey = @ForeignKey(foreignKeyDefinition = ""))
    private int crmId;

    @Column(name = "country_id")
    private Integer countryId;

    @Column(name = "status", columnDefinition = "TINYINT(1)")
    private Byte status;

    @Column(name = "ita")
    private Integer ita;

    @Column(name = "vacancy")
    private Integer vacancy;

    @Column(name = "state_id", columnDefinition = "INT(11) UNSIGNED")
    private Integer stateId;

    public City() {}

}
