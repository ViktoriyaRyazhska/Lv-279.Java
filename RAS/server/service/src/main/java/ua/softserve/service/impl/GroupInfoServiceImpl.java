package ua.softserve.service.impl;

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

//    @Transactional
//    @Override
//    public GroupInfo findOne(Integer id) {
//        GroupInfo groupInfo = groupInfoRepository.findOne(id);
//        if(groupInfo==null){
//            throw new NoSuchElementException("Group with id " + id + " not found");
//        }
//        return groupInfo;
//    }

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
        GroupInfo groupInfo = groupInfoRepository.findByAcademyAcademyId(academyId);
        if (groupInfo == null) {
            throw new NoSuchElementException("Group with id " + academyId + " not found");
        }
        return groupInfo;
    }

    @Override
    public AcademyDTO getAcademyDTObyId(Integer groupId) {
        return groupInfoConverter.toDTO(findOneGroupInfoByAcademyId(groupId));
    }
}
