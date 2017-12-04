package ua.softserve.service.dto;

import lombok.Getter;
import lombok.Setter;
import ua.softserve.persistence.entity.*;

import java.util.List;
import java.util.TreeMap;


@Getter @Setter
public class AcademyDTO {

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
    private int studentActual;
    private TreeMap<String, String> expert;

    List<AcademyStages> academyStages;
    List<LanguageTranslations> cityNames;
    List<Directions> direction;
    List<Technologies> technologie;
    //TODO: rename field
    List<Profile> profile;

}
