package ua.softserve.persistence.dto.Impl;

import java.sql.Timestamp;

import lombok.*;
import ua.softserve.persistence.entity.*;

@Getter @Setter
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
//    private String planedToGraduate;
//    private String planedToEnrollment;
//    private String countActual;
    private StudentGroupCount studentGroupCount;

}
