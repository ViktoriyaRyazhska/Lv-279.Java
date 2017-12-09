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
    TechnologyService technologyService;

    @Autowired
    ProfileService profileService;

    @Autowired
    AcademyService academyService;

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

    public GroupInfo groupInfoToEntity(int academyId, AcademyDTO academyDTO) {
        GroupInfo groupInfo = new GroupInfo();
        groupInfo.setAcademy(getAcademyById(academyId));
        groupInfo.setGroupName(academyDTO.getGrName());
        groupInfo.setProfileInfo(getProfileInfo(academyDTO.getProfileId()));
        groupInfo.setStudentsPlannedToEnrollment(academyDTO.getStudentPlannedToEnrollment());
        groupInfo.setStudentsPlannedToGraduate(academyDTO.getStudentPlannedToGraduate());

        return groupInfo;
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
        return cityService.findOne(id);
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

    private ProfileInfo getProfileInfo(int profileInfoId){
        return profileService.findOne(profileInfoId);
    }

    private Academy getAcademyById(int academyId){
        return academyService.findOne(academyId);
    }

    // TODO: refactor
    // private Profile getProfile(int profileId) {
    // return profileService.findOne(profileId);
    // }
}
