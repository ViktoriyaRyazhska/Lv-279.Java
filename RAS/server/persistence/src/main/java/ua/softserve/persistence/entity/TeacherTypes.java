/*
* TeacherTypes
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
import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "teacher_types")
public class TeacherTypes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_type_id")
    private int teachertypeId;

    @NotNull
    @Column(name = "name")
    private String name;
}
