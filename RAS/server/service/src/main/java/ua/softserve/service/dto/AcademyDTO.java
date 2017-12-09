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
    List<AcademyStages> academyStages;
    List<LanguageTranslations> cityNames;
    List<Directions> direction;
    List<Technologies> technologie;
    // TODO: rename field
    List<ProfileInfo> profile;
    // TODO: fix grammar errors
    private String grName;
    private String nameForSite;
    private int academyStagesId;
    private String startDate;
    private String endDate;
    private int cityId;
    private int payment;
    private int directionId;
    private int technologieId;
    private int profileId;
    private int studentPlannedToGraduate;
    private int studentPlannedToEnrollment;
    private int studentsActual;

    private String paymentStatus;
    private String profileName;
    private String directionName;
    private String technologyName;
    private String cityName;
    private String status;
    private List<String> experts;

}
