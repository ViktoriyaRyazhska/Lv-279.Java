package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.constants.ConstantsFromDb;
import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.AcademyConverter;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.dto.AcademyForViewDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Service processes information that returns Repositories.
 */
@Service
public class GroupInfoServiceImpl implements GroupInfoService {
    @Autowired
    private GroupInfoRepository groupInfoRepository;

    @Autowired
    private AcademyConverter academyConverter;

    @Autowired
    private AcademyStagesService academyStagesService;

    @Autowired
    private DirectionService directionService;

    @Autowired
    private TechnologyServiceImpl technologyServiceImpl;

    @Autowired
    private ProfileService profileService;

    @Autowired
    private LanguageTranslationsService languageTranslationsService;

    @Autowired
    private GroupInfoTeachersService groupInfoTeachersService;

    @Autowired
    private TeacherTypeService teacherTypeService;

    @Autowired
    private StudentService studentsService;

    @Autowired
    private StudentsStatusesService studentsStatusesService;

    @Override
    public void save(GroupInfo groupInfo) {
        groupInfoRepository.save(groupInfo);
    }

    @Override
    public GroupInfo findOne(int id) {
        return groupInfoRepository.findOne(id);
    }

    /**
     * Method transforms information about academies from all tables into one DTO object.
     *
     * @return information about academies from all tables into one DTO object.
     */
    @Override
    public Map<GroupInformationDTO, Integer> getInfoAboutStudents() {
        List<GroupInformationDTO> allInfoAboutGroups = findAllInfoAboutGroups();
        Map<GroupInformationDTO, Integer> infoStudentMap= new HashMap<>();
        infoStudentMap.put(allInfoAboutGroups.get(0), 1);
        allInfoAboutGroups.remove(0);
        for(GroupInformationDTO infoAboutGroup: allInfoAboutGroups){
            if(infoStudentMap.containsKey(infoAboutGroup)){
                infoStudentMap.put(infoAboutGroup, infoStudentMap.get(infoAboutGroup) + 1);
            } else {
                infoStudentMap.put(infoAboutGroup, 1);
            }
        }
        return infoStudentMap;
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
    public List<GroupInformationDTO> findAllInfoAboutGroups() {
        return groupInfoRepository.findAllInfoAboutGroups();
    }

    @Override
    public GroupInfo findOneGroupInfoByAcademyId(int academyId) {
        return groupInfoRepository.findByAcademyAcademyId(academyId);
    }
}
