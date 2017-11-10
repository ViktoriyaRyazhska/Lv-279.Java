package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "country")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int country_id;

    @NotNull
    @Column(name = "crm_id")
    private int crm_id;

    @NotNull
    @Column(name = "code", columnDefinition = "")
    private String code; // need fix COLLATE utf8_unicode_ci DEFAULT NULL,

    @NotNull
    @Column(name = "hot_line", columnDefinition = "")
    private String hot_line; // need fix COLLATE utf8_unicode_ci DEFAULT NULL,

    @Column(name = "status", columnDefinition = "")
    private byte status; // need fix DEFAULT NULL,

    @Column(name = "ita", columnDefinition = "")
    private int ita; // need fix DEFAULT NULL,

    @Column(name = "vacancy", columnDefinition = "")
    private int vacancy; // need fix DEFAULT NULL,




}
