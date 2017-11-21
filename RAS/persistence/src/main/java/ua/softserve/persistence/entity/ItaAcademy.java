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

import javax.jws.soap.SOAPBinding;
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
    private Integer itAcademyId;

    @ManyToOne // (targetEntity = User.class, fetch=FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne //(fetch=FetchType.EAGER)
    @JoinColumn(name = "academyId", referencedColumnName = "academyId")
    private Academy academy;


    @Column(name = "it_academy_status_id")
    private Integer itaAcademyStatus;


    @Override
    public String toString() {
        return "ItaAcademy{" +
                "itAcademyId=" + itAcademyId +
                ", user=" + user.getId() +
                ", academy=" + academy.getAcademyId() +
                ", itaAcademyStatus=" + itaAcademyStatus +
                '}';
    }

}

