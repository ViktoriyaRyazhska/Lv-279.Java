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
    // TODO: fix grammar errors
    private Integer id;
    private String grName;
    private String nameForSite;
    private int academyStagesId;
    private Long startDate;
    private Long endDate;
    private int cityId;
    private int payment;
    private int directionId;
    private int technologieId;
    private int profileId;
    private int studentPlannedToGraduate;
    private int studentPlannedToEnrollment;
    private int studentsActual;

    List<AcademyStages> academyStages;
    List<LanguageTranslations> cityNames;
    List<Directions> direction;
    List<Technologies> technologie;
    List<ProfileInfo> profile; // TODO: rename field

    private String paymentStatus;
    private String profileName;
    private String directionName;
    private String technologyName;
    private String cityName;
    private String status;
    private List<String> experts;
}
