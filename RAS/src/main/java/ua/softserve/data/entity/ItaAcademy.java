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

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ita_academy")
public class ItaAcademy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "it_academy_id")
    private int id;

    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    @OneToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;

    @OneToOne
    @JoinColumn(name = "it_academy_slot_id")
    private ItaTimeSlots techSlot;

    @OneToOne
    @JoinColumn(name = "it_academy_slot_id")
    private ItaTimeSlots engSlot;

    @OneToOne
    @JoinColumn(name = "it_academy_status_id")
    private ItaAcademyStatus itaAcademyStatus;

}

