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
    private String name;

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

    public Academy() {}

    public int getAcademy_id() {
        return academy_id;
    }

    public void setAcademy_id(int academy_id) {
        this.academy_id = academy_id;
    }

    public City getCity_id() {
        return city_id;
    }

    public void setCity_id(City city_id) {
        this.city_id = city_id;
    }

    public Directions getDirectionsSet() {
        return directionsSet;
    }

    public void setDirectionsSet(Directions directionsSet) {
        this.directionsSet = directionsSet;
    }

    public Technologies getTechnologiesSet() {
        return technologiesSet;
    }

    public void setTechnologiesSet(Technologies technologiesSet) {
        this.technologiesSet = technologiesSet;
    }

    public Academy_Stages getAcademy_stagesSet() {
        return academy_stagesSet;
    }

    public void setAcademy_stagesSet(Academy_Stages academy_stagesSet) {
        this.academy_stagesSet = academy_stagesSet;
    }

    public int getCrm_group() {
        return crm_group;
    }

    public void setCrm_group(int crm_group) {
        this.crm_group = crm_group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Timestamp getStart_date() {
        return start_date;
    }

    public void setStart_date(Timestamp start_date) {
        this.start_date = start_date;
    }

    public Timestamp getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Timestamp end_date) {
        this.end_date = end_date;
    }

    public int getFree() {
        return free;
    }

    public void setFree(int free) {
        this.free = free;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getHas_tech() {
        return has_tech;
    }

    public void setHas_tech(int has_tech) {
        this.has_tech = has_tech;
    }

    public int getHas_eng() {
        return has_eng;
    }

    public void setHas_eng(int has_eng) {
        this.has_eng = has_eng;
    }

    public int getHas_first() {
        return has_first;
    }

    public void setHas_first(int has_first) {
        this.has_first = has_first;
    }

    public int getNot_synchronized() {
        return not_synchronized;
    }

    public void setNot_synchronized(int not_synchronized) {
        this.not_synchronized = not_synchronized;
    }

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
