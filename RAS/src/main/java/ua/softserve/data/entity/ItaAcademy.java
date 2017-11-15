/*
* ItaAcademy
*
* Version 1.0-SNAPSHOT
*
* 14.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ita_academy")
public class ItaAcademy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ita_academy_id")
    private int id;

    @OneToOne
    private User user;

    @OneToOne
    private Academy academy;

    @OneToOne
    private ItaTimeSlots techSlot;

    @OneToOne
    private ItaTimeSlots engSlot;

    @OneToOne
    private ItaAcademyStatus itaAcademyStatus;

}
