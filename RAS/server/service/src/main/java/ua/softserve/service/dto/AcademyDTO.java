package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AcademyDTO {
    private int academyId;
    private int groupInfoId;
    private String grName;
    private String nameForSite;
    private Long startDate;
    private Long endDate;
    private int payment;
    private int cityId;
    private int academyStagesId;
    private int directionId;
    private int technologieId;
    private int profileId;
    private int studentPlannedToGraduate;
    private int studentPlannedToEnrollment;
    private int studentsActual;
    private String modifyBy;
}
