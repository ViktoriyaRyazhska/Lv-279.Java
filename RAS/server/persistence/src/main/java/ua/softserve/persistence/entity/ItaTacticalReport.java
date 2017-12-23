package ua.softserve.persistence.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "tacticalreport")
public class ItaTacticalReport {

    @Id
    @Column(name = "academy_id")
    private Integer academy_id;

    @Column(name = "year")
    private int year;

    @Column(name = "month")
    private int month;

    @Column(name = "group_name")
    private String groupName;

    @Column(name = "cg")
    private String CG;

    @Column(name = "profile")
    private String profile;

    @Column(name = "location")
    private String location;

    @Column(name = "requested")
    private int requested;

    @Column(name = "study_in_progress")
    private int studyInProgress;

    @Column(name = "graduated")
    private int graduated;

    @Column(name = "hired")
    private int hired;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "trainers")
    private String trainers;

//    @Column(name = "comment")
//    private String comment;

    @Column(name = "payment_status")
    private int paymentSatus;
}
