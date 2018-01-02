package ua.softserve.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.*;
import ua.softserve.service.dto.AcademyDTO;

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

    @Autowired
    StudentService studentService;

    public AcademyDTO toDTO(GroupInfo groupInfo) {
        AcademyDTO academyDTO = new AcademyDTO();
        academyDTO.setAcademyId(groupInfo.getAcademy().getAcademyId());
        academyDTO.setGroupInfoId(groupInfo.getGroupInfoId());
        academyDTO.setGrName(groupInfo.getGroupName());
        academyDTO.setNameForSite(groupInfo.getAcademy().getName());
        academyDTO.setStartDate(groupInfo.getAcademy().getStartDate().getTime());
        academyDTO.setEndDate(groupInfo.getAcademy().getEndDate().getTime());
        if(groupInfo.getAcademy().getTechnologies() != null) {
            academyDTO.setTechnologieId(groupInfo.getAcademy().getTechnologies().getTechnologyId());
        }
        if(groupInfo.getAcademy().getDirections() != null){
            academyDTO.setDirectionId(groupInfo.getAcademy().getDirections().getDirectionId());
        }
        if(groupInfo.getProfileInfo() != null) {
            academyDTO.setProfileId(groupInfo.getProfileInfo().getProfileId());
        }
        if(groupInfo.getAcademy().getAcademyStages() != null) {
            academyDTO.setAcademyStagesId(groupInfo.getAcademy().getAcademyStages().getStageId());
        }
        if(groupInfo.getAcademy().getCity() != null) {
            academyDTO.setCityId(groupInfo.getAcademy().getCity().getCityId());
        }
        academyDTO.setPayment(groupInfo.getAcademy().getFree());
        academyDTO.setStudentPlannedToGraduate(groupInfo.getStudentsPlannedToGraduate());
        academyDTO.setStudentPlannedToEnrollment(groupInfo.getStudentsPlannedToEnrollment());
        academyDTO.setStudentsActual(studentService.countAllByAcademyId(groupInfo.getAcademy().getAcademyId()));

        return academyDTO;
    }

    /**
     * Method convert AcademyDTO to GroupInfo.
     *
     * @param academyId
     * @param academyDTO
     * @return GroupInfo
     */
    public GroupInfo groupInfoToEntity(int academyId, AcademyDTO academyDTO) {
        GroupInfo groupInfo;

        if (academyDTO.getGroupInfoId() == 0) {
            groupInfo = new GroupInfo();
        } else {
            groupInfo = groupInfoService.findOneGroupInfoByAcademyId(academyDTO.getAcademyId());
            groupInfo.setGroupInfoId(academyDTO.getGroupInfoId());
        }

        groupInfo.setAcademy(getAcademyById(academyId));
        groupInfo.setGroupName(academyDTO.getGrName());
        groupInfo.setProfileInfo(getProfileInfo(academyDTO.getProfileId()));
        groupInfo.setStudentsPlannedToEnrollment(academyDTO.getStudentPlannedToEnrollment());
        groupInfo.setStudentsPlannedToGraduate(academyDTO.getStudentPlannedToGraduate());

        return groupInfo;
    }

    /**
     * Method convert AcademyDTO to Academy
     *
     * @param academyDTO
     * @return Academy
     */
    public Academy academyToEntity(AcademyDTO academyDTO) {
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
