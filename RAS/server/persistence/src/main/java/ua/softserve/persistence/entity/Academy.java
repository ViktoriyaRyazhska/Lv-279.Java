package ua.softserve.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Date;

@Getter @Setter
@Entity
@Table(name = "academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "academy_id")
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
    private Date startDate;

    @NotNull
    @Column(name = "end_date")
    private Date endDate;

    @NotNull
    @Column(name = "free")
    private Integer free;

    @NotNull
    @Column(name = "status")
    private Integer status;

    @NotNull
    @Column(name = "has_tech")
    private Integer hasTech;

    @NotNull
    @Column(name = "has_eng")
    private Integer hasEng;

    @NotNull
    @Column(name = "has_first")
    private Integer hasFirst;

    @NotNull
    @Column(name = "not_synchronized")
    private Integer notSynchronized;

    public Academy() {}
}
