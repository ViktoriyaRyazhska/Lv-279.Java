package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class AcademyForSaveDTO {
    private String grName;
    private String nameForSite;
    private int academyStagesId;
    private Long startDate;
    private Long endDate;
    private int payment;
    private int studentPlannedToGraduate;
    private int studentPlannedToEnrollment;
    private int studentsActual;
    private int directionId;
    private int technologieId;
    private int profileId;
    private int cityId;
}
