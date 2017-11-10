package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name = "directions")
public class Directions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int direction_id;

    @NotNull
    @Column(name = "name")
    private String name; // need fix COLLATE utf8_unicode_ci NOT NULL

    @NotNull
    @Column(name = "item", columnDefinition = "")
    private String item; // need fix COLLATE utf8_unicode_ci NOT NULL

    @Column(name = "crm_id")
    private Integer crm_id; // need fix unsigned DEFAULT NULL

    @Column(name = "ita", columnDefinition = "")
    private byte ita; // need fix unsigned DEFAULT NULL

    @Column(name = "vacancy", columnDefinition = "")
    private byte vacancy; // need fix unsigned DEFAULT NULL

    @Column(name = "status", columnDefinition = "")
    private byte status; // need fix unsigned DEFAULT NULL

}
