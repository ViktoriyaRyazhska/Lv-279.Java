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
    private Academy_Stages academy_stages;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private Profile profile;

    @OneToOne
    @JoinColumn(name = "student_group_count_id")
    private Student_Group_Count student_group_count;

    @NotNull
    @Column(name = "crm_group")
    private int crm_group;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "start_date")
    private Timestamp start_date;

    @NotNull
    @Column(name = "end_date")
    private Timestamp end_date;

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
                ", city=" + city +
                ", directions=" + directions +
                ", technologies=" + technologies +
                ", academy_stages=" + academy_stages +
                ", profile=" + profile +
                ", student_group_count=" + student_group_count +
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

