package ua.softserve.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.*;
import ua.softserve.service.dto.AcademyForSaveDTO;

import java.sql.Date;

@Service
public class GroupInfoConverter {

    @Autowired
    AcademyService academyService;

    @Autowired
    ProfileService profileService;

    @Autowired
    GroupInfoService groupInfoService;

    @Autowired
    CityService cityService;

    @Autowired
    AcademyStagesService academyStagesService;

    @Autowired
    DirectionService directionService;

    @Autowired
    TechnologyService technologyService;

    public AcademyForSaveDTO toDTO(GroupInfo groupInfo) {
        AcademyForSaveDTO academyForSaveDTO = new AcademyForSaveDTO();
        academyForSaveDTO.setAcademyId(groupInfo.getAcademy().getAcademyId());
        academyForSaveDTO.setGroupInfoId(groupInfo.getGroupInfoId());
        academyForSaveDTO.setGrName(groupInfo.getGroupName());
        if (groupInfo.getAcademy().getName() != null) {
            academyForSaveDTO.setNameForSite(groupInfo.getAcademy().getName());
        }
        academyForSaveDTO.setStartDate(groupInfo.getAcademy().getStartDate().getTime());
        academyForSaveDTO.setEndDate(groupInfo.getAcademy().getEndDate().getTime());
        if(groupInfo.getAcademy().getTechnologies() != null) {
            academyForSaveDTO.setTechnologieId(groupInfo.getAcademy().getTechnologies().getTechnologyId());
        }
        if(groupInfo.getAcademy().getDirections() != null){
            academyForSaveDTO.setDirectionId(groupInfo.getAcademy().getDirections().getDirectionId());
        }
        if(groupInfo.getProfileInfo() != null) {
            academyForSaveDTO.setProfileId(groupInfo.getProfileInfo().getProfileId());
        }
        if(groupInfo.getAcademy().getAcademyStages() != null) {
            academyForSaveDTO.setAcademyStagesId(groupInfo.getAcademy().getAcademyStages().getStageId());
        }
        if(groupInfo.getAcademy().getCity() != null) {
            academyForSaveDTO.setCityId(groupInfo.getAcademy().getCity().getCityId());
        }
        academyForSaveDTO.setPayment(groupInfo.getAcademy().getFree());
        academyForSaveDTO.setStudentPlannedToGraduate(groupInfo.getStudentsPlannedToGraduate());
        academyForSaveDTO.setStudentPlannedToEnrollment(groupInfo.getStudentsPlannedToEnrollment());
//        academyForSaveDTO.setStudentsActual();

        return academyForSaveDTO;
    }

    public GroupInfo groupInfoToEntity(int academyId, AcademyForSaveDTO academyDTO) {
        GroupInfo groupInfo;

        if (academyDTO.getAcademyId() == 0) {
            groupInfo = new GroupInfo();
        } else {
            groupInfo = groupInfoService.findOneGroupInfoByAcademyId(academyDTO.getGroupInfoId());
            groupInfo.setGroupInfoId(academyDTO.getGroupInfoId());
        }

        groupInfo.setAcademy(getAcademyById(academyId));
        groupInfo.setGroupName(academyDTO.getGrName());
        groupInfo.setProfileInfo(getProfileInfo(academyDTO.getProfileId()));
        groupInfo.setStudentsPlannedToEnrollment(academyDTO.getStudentPlannedToEnrollment());
        groupInfo.setStudentsPlannedToGraduate(academyDTO.getStudentPlannedToGraduate());

        return groupInfo;
    }

    public Academy academyToEntity(AcademyForSaveDTO academyDTO) {
        Academy academy;

        if (academyDTO.getAcademyId() == 0) {
            academy = new Academy();
        } else {
            academy = academyService.findOne(academyDTO.getAcademyId());
            academy.setAcademyId(academyDTO.getAcademyId());
        }

        academy.setName(academyDTO.getNameForSite());
        academy.setAcademyStages(getAcademyStages(academyDTO.getAcademyStagesId()));
        academy.setStartDate(convertLongToDate(academyDTO.getStartDate()));
        academy.setEndDate(convertLongToDate(academyDTO.getEndDate()));
        academy.setCity(getCity(academyDTO.getCityId()));
        academy.setFree(academyDTO.getPayment());
        academy.setDirections(getDirection(academyDTO.getDirectionId()));
        academy.setTechnologies(getTechnologies(academyDTO.getTechnologieId()));

        return academy;
    }

    private Academy getAcademyById(int academyId) {
        return academyService.findOne(academyId);
    }

    private ProfileInfo getProfileInfo(int profileInfoId) {
        return profileService.findOne(profileInfoId);
    }

    private Date convertLongToDate(Long dateMilliseconds) {
        return new Date(dateMilliseconds);
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
}
