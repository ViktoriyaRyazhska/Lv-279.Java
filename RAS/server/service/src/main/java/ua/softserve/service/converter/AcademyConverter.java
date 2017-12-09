package ua.softserve.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.AcademyStagesService;
import ua.softserve.service.CityService;
import ua.softserve.service.DirectionService;
import ua.softserve.service.TechnologyService;
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
    TechnologyService technologyService;

    public AcademyDTO toDTO(GroupInfo groupInfo) {
        AcademyDTO academyDTO = new AcademyDTO();

        if (groupInfo.getAcademy() != null) {
            academyDTO.setAcademyStagesId(groupInfo.getAcademy().getAcademyStages().getStageId());
            academyDTO.setStartDate(groupInfo.getAcademy().getStartDate().toString());
            academyDTO.setDirectionName(groupInfo.getAcademy().getDirections().getName());
            academyDTO.setTechnologyName(groupInfo.getAcademy().getTechnologies().getName());
            academyDTO.setPayment(groupInfo.getAcademy().getFree());
            if (groupInfo.getAcademy().getFree() == 1) {
                academyDTO.setPaymentStatus("Founded by SoftServe");
            } else {
                academyDTO.setPaymentStatus("Paid");
            }
            academyDTO.setEndDate(groupInfo.getAcademy().getEndDate().toString());
            academyDTO.setNameForSite(groupInfo.getAcademy().getName());
        }
        if (groupInfo.getProfileInfo() != null) {
            academyDTO.setProfileName(groupInfo.getProfileInfo().getProfileName());
        }
        academyDTO.setGrName(groupInfo.getGroupName());
        academyDTO.setStudentPlannedToEnrollment(groupInfo.getStudentsPlannedToEnrollment());
        academyDTO.setStudentPlannedToGraduate(groupInfo.getStudentsPlannedToGraduate());
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

        // TODO: refactor
        // academy.setProfile(getProfile(academyDTO.getProfileId()));
        // academy.setStudentGroupCount(studentGroupCountService.saveDTO(academyDTO));

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
            // throw new ("Can't find city with id = " + id);
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
        return technologyService.findOne(technologieId);
    }

    // TODO: refactor
    // private Profile getProfile(int profileId) {
    // return profileService.findOne(profileId);
    // }
}
