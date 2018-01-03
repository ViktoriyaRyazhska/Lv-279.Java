package ua.softserve.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.persistence.repo.impl.GroupInfoCustomRepository;
import ua.softserve.service.*;
import ua.softserve.service.dto.AcademyDTO;

import java.util.*;

/**
 * Service processes information that returns Repositories.
 */
@Service
public class GroupInfoServiceImpl implements GroupInfoService {
    private final Logger logger = LoggerFactory.getLogger(GroupInfoServiceImpl.class.getName());

    @Autowired
    private GroupInfoRepository groupInfoRepository;

    @Autowired
    private GroupInfoCustomRepository groupInfoCustomRepository;

    @Autowired
    DirectionService directionService;

    @Autowired
    TechnologyService technologyService;

    @Autowired
    CityService cityService;

    @Autowired
    StudentService studentService;

    @Transactional
    @Override
    public void save(GroupInfo groupInfo) {
        groupInfoRepository.save(groupInfo);
    }

    /**
     * Method combines information about groups and information about experts.
     *
     * @return List that contains information about group.
     */
    @Override
    public List<GroupInformationDTO> getAllInformationAboutGroup() {
        return groupInfoCustomRepository.getAllInformationAboutGroups();
    }

    /**
     * Method returns GroupInfo by academy id.
     *
     * @param academyId must not be {@literal null}.
     * @return GroupInfo entity
     * @throws NoSuchElementException if {@code id} is {@literal null}
     */
    @Transactional
    @Override
    public GroupInfo findOneGroupInfoByAcademyId(Integer academyId) {
        logger.info("Before groupInfoRepository.findByAcademyAcademyId(academyId)");

        GroupInfo groupInfo = groupInfoRepository.findByAcademyAcademyId(academyId);
        if (groupInfo == null) {
            logger.error("Group with id " + academyId + " not found");
            throw new NoSuchElementException("Group with id " + academyId + " not found");
        }
        return groupInfo;
    }


    /**
     * Method convert GroupInfo to AcademyDTO.
     *
     * @param academyId must not be {@literal null}.
     * @return AcademyDTO
     */
    public AcademyDTO getAcademyDTObyId(Integer academyId) {
        GroupInfo groupInfo = findOneGroupInfoByAcademyId(academyId);
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
}
