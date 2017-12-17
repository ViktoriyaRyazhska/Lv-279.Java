package ua.softserve.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class GroupInformationDTO {
    private Integer groupInfoId;
    private String groupName;
    private Integer studentsPlannedToGraduate;
    private Integer studentsPlannedToEnrollment;
    private Date startDate;
    private Date endDate;
    private int paymentStatus;
    private String nameForSite;
    private String profileName;
    private String directionName;
    private String status;
    private String firstName;
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupInformationDTO that = (GroupInformationDTO) o;

        if (paymentStatus != that.paymentStatus) return false;
        if (groupInfoId != null ? !groupInfoId.equals(that.groupInfoId) : that.groupInfoId != null) return false;
        if (groupName != null ? !groupName.equals(that.groupName) : that.groupName != null) return false;
        if (studentsPlannedToGraduate != null ? !studentsPlannedToGraduate.equals(that.studentsPlannedToGraduate) : that.studentsPlannedToGraduate != null)
            return false;
        if (studentsPlannedToEnrollment != null ? !studentsPlannedToEnrollment.equals(that.studentsPlannedToEnrollment) : that.studentsPlannedToEnrollment != null)
            return false;
        if (startDate != null ? !startDate.equals(that.startDate) : that.startDate != null) return false;
        if (endDate != null ? !endDate.equals(that.endDate) : that.endDate != null) return false;
        if (nameForSite != null ? !nameForSite.equals(that.nameForSite) : that.nameForSite != null) return false;
        if (profileName != null ? !profileName.equals(that.profileName) : that.profileName != null) return false;
        if (directionName != null ? !directionName.equals(that.directionName) : that.directionName != null)
            return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        return lastName != null ? lastName.equals(that.lastName) : that.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = groupInfoId != null ? groupInfoId.hashCode() : 0;
        result = 31 * result + (groupName != null ? groupName.hashCode() : 0);
        result = 31 * result + (studentsPlannedToGraduate != null ? studentsPlannedToGraduate.hashCode() : 0);
        result = 31 * result + (studentsPlannedToEnrollment != null ? studentsPlannedToEnrollment.hashCode() : 0);
        result = 31 * result + (startDate != null ? startDate.hashCode() : 0);
        result = 31 * result + (endDate != null ? endDate.hashCode() : 0);
        result = 31 * result + paymentStatus;
        result = 31 * result + (nameForSite != null ? nameForSite.hashCode() : 0);
        result = 31 * result + (profileName != null ? profileName.hashCode() : 0);
        result = 31 * result + (directionName != null ? directionName.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }
}
