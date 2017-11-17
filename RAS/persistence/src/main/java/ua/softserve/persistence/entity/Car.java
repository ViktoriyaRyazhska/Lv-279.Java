/*
* Car
*
* Version 1.0-SNAPSHOT
*
* 17.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.persistence.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "car_id")
    private int id;

    private String name;

    @OneToOne
    @JoinColumn(name = "id", foreignKey = @ForeignKey(foreignKeyDefinition = "car_ibfk_1"))
    private Driver driver_id;
}
