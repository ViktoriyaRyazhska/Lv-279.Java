package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Getter
@Setter
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

}
