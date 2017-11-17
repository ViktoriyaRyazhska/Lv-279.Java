/*
* Driver
*
* Version 1.0-SNAPSHOT
*
* 17.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "driver_id")
    private int id;

    private String name;
}
