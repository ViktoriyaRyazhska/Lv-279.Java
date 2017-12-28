package ua.softserve.persistence.entity.views;

import lombok.*;
import ua.softserve.persistence.entity.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "group_information")
public class GroupInformation {

    @Id
    @Column(name = "academy_id")
    private Long academyId;

    @Column(name = "groupName")
    private String groupName;

    @Column(name = "studentsPlannedToGraduate")
    private Integer studentsPlannedToGraduate;

    @Column(name = "studentsPlannedToEnrollment")
    private Integer studentsPlannedToEnrollment;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "paymentStatus")
    private Integer paymentStatus;

    @Column(name = "nameForSite")
    private String nameForSite;

    @Column(name = "profileName")
    private String profileName;

    @Column(name = "directionName")
    private String directionName;

    @Column(name = "commonDirectionName")
    private String commonDirectionName;

    @Column(name = "status")
    private String status;

    @Column(name = "cityName")
    private String cityName;

    @Column(name = "studentsActual")
    private Long studentsActual;

    @Column(name = "firstName")
    private String employee;

    @Column(name = "teacherType")
    private Integer teacherType;

}
