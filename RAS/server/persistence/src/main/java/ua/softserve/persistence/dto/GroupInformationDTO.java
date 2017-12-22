package ua.softserve.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.GroupInfoTeachers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class GroupInformationDTO {
    private Integer academyId;
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
    private Long studentsActual;
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupInformationDTO that = (GroupInformationDTO) o;

        if (paymentStatus != that.paymentStatus) return false;
        if (academyId != null ? !academyId.equals(that.academyId) : that.academyId != null) return false;
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
        return studentsActual != null ? studentsActual.equals(that.studentsActual) : that.studentsActual == null;
    }

    @Override
    public int hashCode() {
        int result = academyId != null ? academyId.hashCode() : 0;
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
        result = 31 * result + (studentsActual != null ? studentsActual.hashCode() : 0);
        return result;
    }
}
