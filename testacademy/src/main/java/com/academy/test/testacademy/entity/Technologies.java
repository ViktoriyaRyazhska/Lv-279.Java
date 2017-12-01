package com.academy.test.testacademy.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter @Setter
@ToString
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

    @Column(name = "status")
    private char status = '1';

    @Column(name = "position")
    private Integer position;

    @Column(name = "price")
    private Integer price;

    @Column(name = "ita")
    private Byte ita;

    @Column(name = "vacancy")
    private Byte vacancy;

    @Column(name = "name")
    private String name;

    @Column(name = "directiond_id", columnDefinition = "INT(11) UNSIGNED")
    private int directiondId;

    @Column(name = "crm_id")
    private Integer crmId;

    public Technologies() {}
}
