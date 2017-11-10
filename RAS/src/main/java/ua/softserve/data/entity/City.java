package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int city_id;

    @NotNull
    @Column(name = "crm_id")
    private int crm_id;

    @Column(name = "country_id", columnDefinition = "")
    private int country_id; //need fix unsigned DEFAULT NULL

    @Column(name = "status", columnDefinition = "")
    private byte status; //need fix DEFAULT NULL

    @Column(name = "ita", columnDefinition = "")
    private int ita; //need fix DEFAULT NULL

    @Column(name = "vacancy", columnDefinition = "")
    private int vacancy; //need fix DEFAULT NULL

    @Column(name = "state_id", columnDefinition = "0")
    private Integer state_id; //need fix unsigned DEFAULT NULL
}
