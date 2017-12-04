package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.TeacherTypes;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.persistence.repo.GroupInfoTeachersRepository;
import ua.softserve.persistence.repo.TeacherTypeRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.AcademyConverter;
import ua.softserve.service.dto.AcademyDTO;

import java.util.ArrayList;
import java.util.List;

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
    private GroupInfoTeachersRepository groupInfoTeachersRepository;

    @Autowired
    private TeacherTypeRepository teacherTypeRepository;

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
        for (GroupInfo groupInfo : groupInfoList) {
            AcademyDTO academyDTO = academyConverter.toDTO(groupInfo);
            academyDTO.setAcademyStages(academyStagesService.getAllAcademyStagesService());
            academyDTO.setDirection(directionService.findAllDirectionsInIta());
            academyDTO.setTechnologie(technologyServiceImpl.findAllTechonologyInIta());
            academyDTO.setProfile(profileService.findAll());
            academyDTO.setCityNames(languageTranslationsService.getAllLanguageTranslationsName());
            TeacherTypes teacherTypes = teacherTypeRepository.findOne(1);
            List<GroupInfoTeachers> allByAcademyAndTeacherType =
                    groupInfoTeachersRepository.findAllByAcademyAndTeacherType(groupInfo.getAcademy(), teacherTypes);
            List<String> employeeList = new ArrayList<>();
            for (GroupInfoTeachers groupInfoTeachers : allByAcademyAndTeacherType) {
                employeeList.add(groupInfoTeachers.getEmployee().getFirstNameEng() + " " +
                                groupInfoTeachers.getEmployee().getLastNameEng());
            }
            academyDTO.setExperts(employeeList);
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
