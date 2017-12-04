package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.service.GroupInfoService;
import ua.softserve.service.converter.AcademyConverter;
import ua.softserve.service.dto.AcademyDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class GroupInfoServiceImpl implements GroupInfoService{
    @Autowired
    private GroupInfoRepository groupInfoRepository;

    @Autowired
    private AcademyConverter academyConverter;

    @Override
    public void save(GroupInfo groupInfo) {
        //TODO: implements method
        //NOP
    }

    @Override
    public GroupInfo findOne(int id) {
        return groupInfoRepository.findOne(id);
    }

    @Override
    public List<AcademyDTO> getAllAcademies() {
        List<GroupInfo> groupInfoList = groupInfoRepository.findAll();
        List<AcademyDTO> academyDTOList = new ArrayList<AcademyDTO>();
        for(GroupInfo groupInfo: groupInfoList){
            AcademyDTO academyDTO = academyConverter.toDTO(groupInfo);
            academyDTOList.add(academyDTO);
        }
        return academyDTOList;
    }

//TODO: refactor this
//    @Transactional
//    @Override
//    public List<AcademyDTO> findWithEmployeeExperts() {
//        List<Academy> academies = academyRepository.findWithEmployeeExperts();
//        List<AcademyDTO> academyDTOS = new ArrayList<>();
//        for(Academy academy: academies){
//            AcademyDTO academyDTO = academyConverter.toDTO(academy);
//            academyDTOS.add(academyDTO);
//        }
//        return academyDTOS;
//    }


}
