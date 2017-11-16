/*
* Academy
*
* Version 1.0-SNAPSHOT
*
* 14.11.17
*
* All rights reserved by DoubleO Team (Team#1)
*/


package ua.softserve.persistence.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academy_id")
    private int id;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "city_id", insertable = false, updatable = false)
//    private City city;

//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "direction_id")
//    private Direction direction;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "technology_id")
//    private Technology technology;
//
//    @OneToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "stage_id")
//    private AcademyStage stage;

    @Column(nullable = false)
    private String name;

    @Column(name = "start_date", nullable = false)
    private Date startDate;

    @Column(name = "end_date", nullable = false)
    private Date endDate;

    @Column(nullable = false)
    private int free;

}

