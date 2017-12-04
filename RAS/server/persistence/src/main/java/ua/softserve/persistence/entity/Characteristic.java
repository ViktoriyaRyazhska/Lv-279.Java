/*
* Mark
*
* Version 1.0-SNAPSHOT
*
* 02.12.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.persistence.entity;

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
@Table(name = "characteristic")
public class Characteristic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "characteristic_id")
    private int id;

    private String name;
}