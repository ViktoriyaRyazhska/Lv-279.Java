/*
* Technology
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "technologies")
public class Technology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "technology_id")
    private int id;

    @Column(nullable = false)
    private int free;

    private int price;

    private String name;

    private boolean ita;

    private int directiond_id;

}
