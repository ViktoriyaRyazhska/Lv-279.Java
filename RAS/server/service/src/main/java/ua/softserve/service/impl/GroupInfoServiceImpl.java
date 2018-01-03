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
import ua.softserve.service.converter.GroupInfoConverter;
import ua.softserve.service.dto.AcademyDTO;

import java.util.*;

/**
 * Service processes information that returns Repositories.
 */
@Service
public class GroupInfoServiceImpl implements GroupInfoService {
    private final Logger logger = LoggerFactory.getLogger(AcademyServiceImpl.class.getName());

    @Autowired
    private GroupInfoRepository groupInfoRepository;

    @Autowired
    private GroupInfoCustomRepository groupInfoCustomRepository;

    @Autowired
    private GroupInfoConverter groupInfoConverter;

    @Autowired
    DirectionService directionService;

    @Autowired
    TechnologyService technologyService;

    @Autowired
    CityService cityService;

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
     * Method returns GroupInfo by id
     * @param academyId
     * @return GroupInfo
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

    @Override
    public AcademyDTO getAcademyDTObyId(Integer groupId) {
        return groupInfoConverter.toDTO(findOneGroupInfoByAcademyId(groupId));
    }
}
