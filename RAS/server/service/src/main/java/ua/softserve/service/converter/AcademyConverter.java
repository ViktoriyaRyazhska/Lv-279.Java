package ua.softserve.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.*;
import ua.softserve.service.dto.AcademyDTO;

import java.sql.Date;

/**
 * Service transforms GroupInfo Entity to DTO object and DTO object to GroupInfo Entity. Also it transforms AcademyDTO
 * object to Academy Entity.
 */
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

    /**
     * Method transforms GroupInfo Entity to AcademyDTO object.
     * 
     * @param groupInfo
     *            is a object that will be transformed.
     * @return AcademyDTO object.
     */
    public AcademyDTO toDTO(GroupInfo groupInfo) {
        AcademyDTO academyDTO = new AcademyDTO();
        Academy academy = groupInfo.getAcademy();
        if (academy != null) {
            academyDTO.setId(groupInfo.getGroupInfoId());
            academyDTO.setAcademyId(groupInfo.getAcademy().getAcademyId());
            if (academy.getAcademyStages() != null) {
                academyDTO.setAcademyStagesId(academy.getAcademyStages().getStageId());
            }
            if (academy.getStartDate() != null) {
                academyDTO.setStartDate(academy.getStartDate().getTime());
            }
            if (academy.getDirections() != null) {
                academyDTO.setDirectionName(academy.getDirections().getName());
            }
            if (academy.getTechnologies() != null) {
                academyDTO.setTechnologyName(academy.getTechnologies().getName());
            }
            academyDTO.setPayment(academy.getFree());
            if (academy.getFree() == 1) {
                academyDTO.setPaymentStatus("Founded by SoftServe");
            } else {
                academyDTO.setPaymentStatus("Paid");
            }
            if (academy.getEndDate() != null) {
                academyDTO.setEndDate(academy.getEndDate().getTime());
            }
            academyDTO.setNameForSite(academy.getName());
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
        Date startDate = convertLongToDate(academyDTO.getStartDate());
        academy.setStartDate(startDate);
        academy.setEndDate(convertLongToDate(academyDTO.getEndDate()));
        academy.setCity(getCity(academyDTO.getCityId()));
        academy.setFree(academyDTO.getPayment());
        academy.setDirections(getDirection(academyDTO.getDirectionId()));
        academy.setTechnologies(getTechnologies(academyDTO.getTechnologieId()));

        System.out.println(startDate);

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

    private ProfileInfo getProfileInfo(int profileInfoId) {
        return profileService.findOne(profileInfoId);
    }

    private Academy getAcademyById(int academyId) {
        return academyService.findOne(academyId);
    }

}
