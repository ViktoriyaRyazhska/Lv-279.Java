package ua.softserve.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
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
    private List<String> firstName;
    private List<String> lastName;

    public GroupInformationDTO(Integer academyId, String groupName, Integer studentsPlannedToGraduate, Integer studentsPlannedToEnrollment, Date startDate, Date endDate, int paymentStatus, String nameForSite, String profileName, String directionName, String status, Long studentsActual) {
        this.academyId = academyId;
        this.groupName = groupName;
        this.studentsPlannedToGraduate = studentsPlannedToGraduate;
        this.studentsPlannedToEnrollment = studentsPlannedToEnrollment;
        this.startDate = startDate;
        this.endDate = endDate;
        this.paymentStatus = paymentStatus;
        this.nameForSite = nameForSite;
        this.profileName = profileName;
        this.directionName = directionName;
        this.status = status;
        this.studentsActual = studentsActual;
        this.firstName = new ArrayList<>();
        this.lastName = new ArrayList<>();
    }
}
