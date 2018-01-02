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
@AllArgsConstructor
@NoArgsConstructor
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
    private List<String> firstName;
    private List<String> lastName;
    private Integer teacherType;

    public void setFirstName(String firstName) {
        this.firstName = new ArrayList<>();
        this.firstName.add(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName = new ArrayList<>();
        this.lastName.add(lastName);
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        GroupInformationDTO that = (GroupInformationDTO) o;

        return new EqualsBuilder()
                .append(academyId, that.academyId)
                .append(groupName, that.groupName)
                .append(studentsPlannedToGraduate, that.studentsPlannedToGraduate)
                .append(studentsPlannedToEnrollment, that.studentsPlannedToEnrollment)
                .append(startDate, that.startDate)
                .append(endDate, that.endDate)
                .append(paymentStatus, that.paymentStatus)
                .append(nameForSite, that.nameForSite)
                .append(profileName, that.profileName)
                .append(directionName, that.directionName)
                .append(commonDirectionName, that.commonDirectionName)
                .append(status, that.status)
                .append(cityName, that.cityName)
                .append(studentsActual, that.studentsActual)
                .append(teacherType, that.teacherType)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(academyId)
                .append(groupName)
                .append(studentsPlannedToGraduate)
                .append(studentsPlannedToEnrollment)
                .append(startDate)
                .append(endDate)
                .append(paymentStatus)
                .append(nameForSite)
                .append(profileName)
                .append(directionName)
                .append(commonDirectionName)
                .append(status)
                .append(cityName)
                .append(studentsActual)
                .append(teacherType)
                .toHashCode();
    }
}
