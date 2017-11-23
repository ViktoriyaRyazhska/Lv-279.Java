package ua.softserve.persistence.dto;

import lombok.*;
import ua.softserve.persistence.entity.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AcademyDTO {

    private String grName;
    private String nameForSite;
    private AcademyStages academyStages;
    private String startDate;
    private String endDate;
    private String cityNames;
    private int payment;
    private Directions direction;
    private Technologies technologie;
    private Profile profile;
    private int studentsPlannedToGraduate;
    private int studentsPlannedToEnrollment;
    private int studentsActual;
}
