package ua.softserve.data.entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "academy")
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int academy_id;

    @ManyToOne
    @JoinColumn(name="city_id")
    private City city_id;

    @ManyToOne
    @JoinColumn(name = "direction_id")
    private Directions directionsSet;

    @ManyToOne
    @JoinColumn(name = "technology_id")
    private Technologies technologiesSet;


    @ManyToOne
    @JoinColumn(name = "stage_id")
    private Academy_Stages academy_stagesSet;

    @NotNull
    @Column(name = "crm_group")
    private int crm_group;

    @NotNull
    @Column(name = "name")
    private String name; // need fix COLLATE utf8_unicode_ci

    @NotNull
    @Column(name = "start_date")
    private Timestamp start_date;//need fix

    @NotNull
    @Column(name = "end_date")
    private Timestamp end_date;//need fix

    @NotNull
    @Column(name = "free")
    private int free;

    @NotNull
    @Column(name = "status")
    private int status;

    @NotNull
    @Column(name = "has_tech")
    private int has_tech;

    @NotNull
    @Column(name = "has_eng")
    private int has_eng;

    @NotNull
    @Column(name = "has_first")
    private int has_first;

    @NotNull
    @Column(name = "not_synchronized")
    private int not_synchronized;


    @Override
    public String toString() {
        return "Academy{" +
                "academy_id=" + academy_id +
                ", citySet=" + city_id +
                ", directionsSet=" + directionsSet +
                ", technologiesSet=" + technologiesSet +
                ", academy_stagesSet=" + academy_stagesSet +
                ", crm_group=" + crm_group +
                ", name='" + name + '\'' +
                ", start_date=" + start_date +
                ", end_date=" + end_date +
                ", free=" + free +
                ", status=" + status +
                ", has_tech=" + has_tech +
                ", has_eng=" + has_eng +
                ", has_first=" + has_first +
                ", not_synchronized=" + not_synchronized +
                '}';
    }
}
