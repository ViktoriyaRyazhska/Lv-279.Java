package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.persistence.repo.impl.GroupInfoCustomRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.GroupInfoConverter;
import ua.softserve.service.dto.AcademyForSaveDTO;

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

    @Override
    public void save(GroupInfo groupInfo) {
        groupInfoRepository.save(groupInfo);
    }

    @Override
    public GroupInfo findOne(int id) {
        return groupInfoRepository.findOne(id);
    }

    /**
     * Method combines information about groups and information about experts.
     *
     * @return List that contains information about group.
     */
    @Override
    public List<GroupInformationDTO> getAllInformationAboutGroup() {
        List<GroupInformationDTO> groupInformation = groupInfoCustomRepository.getAllInformationAboutGroups();
//        final Integer FIRST_ELEMENT_OF_THE_LIST = 0;
//        int listCounter = 0;
//        GroupInformationDTO previousElement = null;
//        GroupInformationDTO currentElement = null;
//        for(GroupInformationDTO groupInformationDTO: groupInformation){
//            if(listCounter >= 2){
//                if(previousElement.equals(currentElement)) {
//                    previousElement.getFirstName().add(currentElement.getFirstName().get(FIRST_ELEMENT_OF_THE_LIST));
//                    previousElement.getLastName().add(currentElement.getLastName().get(FIRST_ELEMENT_OF_THE_LIST));
//                    groupInformation.remove(currentElement);
//                }
//            }
//            listCounter++;
//            previousElement = currentElement;
//            currentElement = groupInformationDTO;
//        }

        for (int i = 1; i < groupInformation.size(); i++) {
            if(groupInformation.get(i).equals(groupInformation.get(i-1))){
                groupInformation.get(i-1).getFirstName().add(groupInformation.get(i).getFirstName().get(0));
                groupInformation.get(i-1).getLastName().add(groupInformation.get(i).getLastName().get(0));
                groupInformation.remove(i);
                i--;
            }
        }
        return groupInformation;
    }

    @Override
    public GroupInfo findOneGroupInfoByAcademyId(int academyId) {
        return groupInfoRepository.findByAcademyAcademyId(academyId);
    }

    @Override
    public AcademyForSaveDTO getAcademyForSaveDTO(Integer groupId) {
        return groupInfoConverter.toDTO(findOneGroupInfoByAcademyId(groupId));
    }
}
