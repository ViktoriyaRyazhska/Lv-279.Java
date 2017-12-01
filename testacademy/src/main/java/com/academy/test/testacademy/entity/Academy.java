package com.academy.test.testacademy.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import javax.validation.constraints.NotNull;


@Getter @Setter
@Entity
@Table(name = "academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "academy_id")
    private Integer academyId;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Directions directions;

    @ManyToOne
    @JoinColumn(name = "technology_id")
    private Technologies technologies;

    @ManyToOne
    @JoinColumn(name = "stage_id")
    private AcademyStages academyStages;


    @NotNull
    @Column(name = "crm_group")
    private int crmGroup;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "start_date")
    private Timestamp startDate;

    @NotNull
    @Column(name = "end_date")
    private Timestamp endDate;

    @NotNull
    @Column(name = "free")
    private int free;

    @NotNull
    @Column(name = "status")
    private int status;

    @NotNull
    @Column(name = "has_tech")
    private int hasTech;

    @NotNull
    @Column(name = "has_eng")
    private int hasEng;

    @NotNull
    @Column(name = "has_first")
    private int hasFirst;

    @NotNull
    @Column(name = "not_synchronized")
    private int notSynchronized;


    @Override
    public String toString() {
        return "Academy{" +
                "academyId=" + academyId +
                ", city=" + city +
                ", directions=" + directions +
                ", technologies=" + technologies +
                ", academyStages=" + academyStages +
                ", crmGroup=" + crmGroup +
                ", name='" + name + '\'' +
                ", startDate=" + startDate.toLocalDateTime().toLocalDate() +
                ", endDate=" + endDate.toLocalDateTime().toLocalDate() +
                ", free=" + free +
                ", status=" + status +
                ", hasTech=" + hasTech +
                ", hasEng=" + hasEng +
                ", hasFirst=" + hasFirst +
                ", notSynchronized=" + notSynchronized +
                '}';
    }
}
