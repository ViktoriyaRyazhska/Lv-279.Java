package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.impl.GroupInfoCustomRepository;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.AcademyConverter;
import ua.softserve.service.converter.GroupInfoConverter;

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

    /**
     * Method returns data from GroupInfo table in order of adding records.
     *
     * @return data from GroupInfo table in order of adding records.
     */
    @Override
    public List<GroupInfo> findAllWithOrder() {
        return groupInfoRepository.findAllWithOrder();
    }

    @Override
    public GroupInfo findOneGroupInfoByAcademyId(int academyId) {
        return groupInfoRepository.findByAcademyAcademyId(academyId);
    }
}
