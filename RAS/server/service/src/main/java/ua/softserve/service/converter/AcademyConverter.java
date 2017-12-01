package ua.softserve.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.*;
import ua.softserve.service.dto.AcademyDTO;

import java.sql.Timestamp;
import java.time.LocalDate;

@Service
public class AcademyConverter {
    @Autowired
    CityService cityService;

    @Autowired
    AcademyStagesService academyStagesService;

    @Autowired
    DirectionService directionService;

    @Autowired
    TechnologieService technologieService;

    @Autowired
    ProfileService profileService;

    @Autowired
    StudentGroupCountService studentGroupCountService;

    public AcademyDTO toDTO(Academy academy) {
        AcademyDTO academyDTO = new AcademyDTO();
//        academyDTO.setGrName();
        academyDTO.setNameForSite(academy.getName());

        if (academy.getAcademyStages() != null) {
            academyDTO.setAcademyStagesId(academy.getAcademyStages().getStageId());
        }
        if (academy.getStartDate() != null) {
            academyDTO.setStartDate(academy.getStartDate().toString());
        }
        academyDTO.setEndDate(academy.getEndDate() != null ? academy.getEndDate().toString() : null);

        if (academy.getCity() != null) {
            academyDTO.setCityId(academy.getCity().getCityId());
        }

        academyDTO.setPayment(academy.getFree());
        if (academy.getDirections() != null) {
            academyDTO.setDirectionId(academy.getDirections().getDirectionId());
        }
        if (academy.getTechnologies() != null) {
            academyDTO.setTechnologieId(academy.getTechnologies().getTechnologyId());
        }
        if (academy.getProfile() != null) {
            academyDTO.setProfileId(academy.getProfile().getProfileId());
        }
        StudentGroupCount studentGroupCount = academy.getStudentGroupCount();
        if (studentGroupCount != null) {
            academyDTO.setStudentPlannedToGraduate(studentGroupCount.getStudentsPlannedToGraduate());
            academyDTO.setStudentPlannedToEnrollment(studentGroupCount.getStudentsPlannedToEnrollment());
            academyDTO.setStudentActual(studentGroupCount.getStudentsActual());

        }
        return academyDTO;
    }

    public Academy toEntity(AcademyDTO academyDTO) {
        Academy academy = new Academy();

        academy.setName(academyDTO.getNameForSite());
        academy.setAcademyStages(getAcademyStages(academyDTO.getAcademyStagesId()));
        academy.setStartDate(convertStringToTimestamp(academyDTO.getStartDate()));
        academy.setEndDate(convertStringToTimestamp(academyDTO.getEndDate()));
        academy.setCity(getCity(academyDTO.getCityId()));
        academy.setFree(academyDTO.getPayment());
        academy.setDirections(getDirection(academyDTO.getDirectionId()));
        academy.setTechnologies(getTechnologies(academyDTO.getTechnologieId()));
        academy.setProfile(getProfile(academyDTO.getProfileId()));
        academy.setStudentGroupCount(studentGroupCountService.saveDTO(academyDTO));

        return academy;
    }

    private Timestamp convertStringToTimestamp(String date) {
        if (date == null) {
            throw new IllegalArgumentException("Date can't be null");
        } else if (date.isEmpty()) {
            throw new IllegalArgumentException("Date can't be empty");
        }

        LocalDate localDate = null;
        Timestamp timestamp = null;

        try {
            localDate = LocalDate.parse(date);
            timestamp = Timestamp.valueOf(localDate.atStartOfDay());
        } catch (ClassCastException e) {
            System.err.println(e);
        }
        return timestamp;
    }

    private City getCity(int id) {
        City city = cityService.findOne(id);
        if (city == null) {
            //throw new ("Can't find city with id = " + id);
        }
        return city;
    }

    private AcademyStages getAcademyStages(int academyStagesId) {
        return academyStagesService.findOne(academyStagesId);
    }

    private Directions getDirection(int direcrionId) {
        return directionService.findOne(direcrionId);
    }

    private Technologies getTechnologies(int technologieId) {
        return technologieService.findOne(technologieId);
    }

    private Profile getProfile(int profileId) {
        return profileService.findOne(profileId);
    }
}
