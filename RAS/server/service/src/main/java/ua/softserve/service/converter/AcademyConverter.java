package ua.softserve.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.*;
import ua.softserve.service.dto.AcademyForSaveDTO;
import ua.softserve.service.dto.AcademyForViewDTO;

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

    /**
     * Method transforms GroupInfo Entity to AcademyDTO object.
     * 
     * @param groupInfo
     *            is a object that will be transformed.
     * @return AcademyDTO object.
     */
    public AcademyForViewDTO toDTO(GroupInfo groupInfo) {
        AcademyForViewDTO academyForViewDTO = new AcademyForViewDTO();
        Academy academy = groupInfo.getAcademy();
        if (academy != null) {
            academyForViewDTO.setId(groupInfo.getGroupInfoId());
            academyForViewDTO.setAcademyId(groupInfo.getAcademy().getAcademyId());
            if (academy.getAcademyStages() != null) {
                academyForViewDTO.setAcademyStagesId(academy.getAcademyStages().getStageId());
            }
            if (academy.getStartDate() != null) {
                academyForViewDTO.setStartDate(academy.getStartDate().getTime());
            }
            if (academy.getDirections() != null) {
                academyForViewDTO.setDirectionName(academy.getDirections().getName());
            }
            if (academy.getTechnologies() != null) {
                academyForViewDTO.setTechnologyName(academy.getTechnologies().getName());
            }
            academyForViewDTO.setPayment(academy.getFree());
            if (academy.getFree() == 1) {
                academyForViewDTO.setPaymentStatus("Founded by SoftServe");
            } else {
                academyForViewDTO.setPaymentStatus("Paid");
            }
            if (academy.getEndDate() != null) {
                academyForViewDTO.setEndDate(academy.getEndDate().getTime());
            }
            academyForViewDTO.setNameForSite(academy.getName());
        }
        if (groupInfo.getProfileInfo() != null) {
            academyForViewDTO.setProfileName(groupInfo.getProfileInfo().getProfileName());
        }
        academyForViewDTO.setGrName(groupInfo.getGroupName());
        academyForViewDTO.setStudentPlannedToEnrollment(groupInfo.getStudentsPlannedToEnrollment());
        academyForViewDTO.setStudentPlannedToGraduate(groupInfo.getStudentsPlannedToGraduate());
        return academyForViewDTO;
    }

    public Academy toEntity(AcademyForSaveDTO academyDTO) {
        Academy academy = new Academy();

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
