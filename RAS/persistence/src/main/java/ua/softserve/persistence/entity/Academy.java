package ua.softserve.persistence.entity;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;

import java.sql.Timestamp;


@Getter @Setter
@Entity
@Table(name = "academy")
public class Academy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int academy_id;

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
    private AcademyStages academy_stages;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToOne
    @JoinColumn(name = "student_group_count_id")
    private StudentGroupCount student_group_count;

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
                "academyId=" + academy_id +
                ", city_id=" + city.getCity_id() +
                ", directionsSet=" + directions.getName() +
                ", technologiesSet=" + technologies.getName() +
                ", academy_stagesSet=" + academy_stages.getName() +
//                ", profile=" + profile.getProfile_name() +
//                ", student_group_count=" + student_group_count +
                ", name='" + name + '\'' +
                ", startDate=" + startDate.toLocalDateTime().toLocalDate() +
                ", endDate=" + endDate.toLocalDateTime().toLocalDate() +
                ", free=" + free +
                ", status=" + status +
                '}';
    }
}

