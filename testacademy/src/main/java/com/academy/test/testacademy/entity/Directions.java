package com.academy.test.testacademy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@ToString
@Entity
@Table(name = "directions")
public class Directions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "direction_id")
    private int directionId;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "item")
    private String item;

    @Column(name = "crm_id")
    private Integer crmId;

    @Column(name = "ita")
    private Byte ita;

    @Column(name = "vacancy")
    private Byte vacancy;

    @Column(name = "status")
    private Byte status;

    public Directions() {}
}
