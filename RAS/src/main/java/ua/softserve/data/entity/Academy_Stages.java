package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "academy_stages")
public class Academy_Stages {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int stage_id;

    @NotNull
    @Column(name = "name")
    private String name; // need fix COLLATE utf8_unicode_ci

    @NotNull
    @Column(name = "sort")
    private byte sort; // need fix COLLATE utf8_unicode_ci

}
