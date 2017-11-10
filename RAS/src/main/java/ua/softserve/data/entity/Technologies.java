package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "technologies")
public class Technologies {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int technology_id;

    @NotNull
    @Column(name = "alias")
    private String alias; // need fix COLLATE utf8_unicode_ci NOT NULL

    @NotNull
    @Column(name = "free")
    private int free;

    @NotNull
    @Column(name = "image")
    private String image; // need fix COLLATE utf8_unicode_ci NOT NULL,

    @NotNull
    @Column(name = "image2")
    private String image2; // need fix COLLATE utf8_unicode_ci NOT NULL,

    @NotNull
    @Column(name = "status", columnDefinition = "1")
    private char status; // COLLATE utf8_unicode_ci DEFAULT '1',

    @Column(name = "position", columnDefinition = "")
    private int position; // need fix DEFAULT NULL,

    @Column(name = "price", columnDefinition = "")
    private Integer price; // DEFAULT NULL,

    @Column(name = "ita", columnDefinition = "")
    private byte ita; // DEFAULT NULL,

    @Column(name = "vacancy", insertable = false, updatable = false)
    private byte vacancy; // DEFAULT NULL,

    @Column(name = "vacancy", columnDefinition = "")
    private String name; // COLLATE utf8_unicode_ci DEFAULT NULL,

    @Column(name = "directiond_id", columnDefinition = "")
    private int directiond_id; // unsigned DEFAULT NULL,

    @Column(name = "crm_id", columnDefinition = "")
    private Integer crm_id; //  DEFAULT NULL,

    @Column(name = "activeGroups", columnDefinition = "")
    private int activeGroups; //  DEFAULT NULL,
}
