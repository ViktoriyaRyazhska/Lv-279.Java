package ua.softserve.persistence.dto;

import lombok.*;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.TeacherTypes;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
public class GroupInformationDTO {
    private Integer academyId;
    private String groupName;
    private Integer studentsPlannedToGraduate;
    private Integer studentsPlannedToEnrollment;
    private Long startDate;
    private Long endDate;
    private String paymentStatus;
    private String nameForSite;
    private String profileName;
    private String directionName;
    private String commonDirectionName;
    private String status;
    private String cityName;
    private Long studentsActual;
    private String experts;
    private Integer teacherType;

    public void setStartDate(Date startDate) {
        this.startDate = startDate.getTime();
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate.getTime();
    }

    public void setPaymentStatus(Integer paymentStatus) {
        if (paymentStatus == 1) {
            this.paymentStatus = "Founded by SoftServe";
        } else {
            this.paymentStatus = "Paid";
        }

    }
}
