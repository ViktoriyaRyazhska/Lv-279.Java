package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.softserve.persistence.entity.*;

import java.util.List;

@Getter
@Setter
@ToString
public class AcademyDTO {
    private String grName;
    private String nameForSite;
    private int academyStagesId;
    private Long startDate;
    private Long endDate;
    private int payment;
    private int studentPlannedToGraduate;
    private int studentPlannedToEnrollment;
    private int studentsActual;
    List<AcademyStages> academyStages;
    List<LanguageTranslations> cityNames;
    List<Directions> direction;
    List<Technologies> technologie;
    List<ProfileInfo> profile;
}
