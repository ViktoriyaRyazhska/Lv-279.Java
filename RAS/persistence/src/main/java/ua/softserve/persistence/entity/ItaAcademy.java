/*
* ItaAcademy
*
* Version 1.0-SNAPSHOT
*
* 14.11.17
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
@Table(name = "ita_academy")
public class ItaAcademy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int it_academy_id;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "academy_id")
    private Academy academy;


    @Column(name="it_academy_status_id")
    private Integer itaAcademyStatus;

    @Override
    public String toString() {
        return "ItaAcademy{" +
                "it_academy_id=" + it_academy_id +
                ", user=" + user +
                ", academy=" + academy+
                ", itaAcademyStatus=" + itaAcademyStatus +
                '}';
    }
//    @OneToOne
//    @JoinColumn(name = "id")
//    private User user;

//    @OneToOne
//    @JoinColumn(name = "academy_id")
//    private Academy academy;

//    @OneToOne
//    @JoinColumn(name = "it_academy_slot_id")
//    private ItaTimeSlots tech_slot_id;
//
//    @OneToOne
//    @JoinColumn(name = "it_academy_slot_id", insertable = false, updatable = false)
//    private ItaTimeSlots eng_slot_id;

//    @OneToOne
//    @JoinColumn(name = "it_academy_slot_id", insertable = false, updatable = false)
//    private ItaAcademyStatus itaAcademyStatus;

}

