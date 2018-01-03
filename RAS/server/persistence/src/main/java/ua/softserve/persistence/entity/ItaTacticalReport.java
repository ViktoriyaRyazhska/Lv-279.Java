package ua.softserve.persistence.entity;

import lombok.*;

import javax.persistence.*;
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
    private Integer academyId;

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

    @Column(name = "student_in_progress")
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
    @Transient
    private String reportName;
}
