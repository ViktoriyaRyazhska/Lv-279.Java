package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
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
    private static final int ID_OF_THE_EXPERT_VALUE = 2;

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
        // TODO: implements method
        // NOP
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
            if (groupInfo.getAcademy() != null) {
                LanguageTranslations languageTranslations = languageTranslationsService
                        .findById(groupInfo.getAcademy().getAcademyId());
                if (languageTranslations != null) {
                    academyDTO.setCityName(languageTranslations.getTrasnlation());
                }

                if (groupInfo.getAcademy().getAcademyStages() != null) {
                    academyDTO.setStatus(groupInfo.getAcademy().getAcademyStages().getName());
                }

                TeacherTypes teacherTypes = teacherTypeRepository.findOne(ID_OF_THE_EXPERT_VALUE);
                List<GroupInfoTeachers> allByAcademyAndTeacherType = groupInfoTeachersRepository
                        .findAllByAcademyAndTeacherType(groupInfo.getAcademy(), teacherTypes);
                List<String> employeeList = new ArrayList<>();
                for (GroupInfoTeachers groupInfoTeachers : allByAcademyAndTeacherType) {
                    employeeList.add(groupInfoTeachers.getEmployee().getFirstNameEng() + " "
                            + groupInfoTeachers.getEmployee().getLastNameEng());
                }
                academyDTO.setExperts(employeeList);
            }
            if (groupInfo.getProfileInfo() != null) {
                academyDTO.setProfileName(groupInfo.getProfileInfo().getProfileName());
            }

            academyDTOList.add(academyDTO);
        }
        // form list for combo-box.
        AcademyDTO academyDTO = new AcademyDTO();
        academyDTO.setAcademyStages(academyStagesService.getAllAcademyStagesService());
        academyDTO.setDirection(directionService.findAllDirectionsInIta());
        academyDTO.setTechnologie(technologyServiceImpl.findAllTechonologyInIta());
        academyDTO.setProfile(profileService.findAll());
        academyDTO.setCityNames(languageTranslationsService.getAllLanguageTranslationsName());
        academyDTOList.add(academyDTO);
        return academyDTOList;
    }

    @Override
    public GroupInfo findOneGroupInfoByAcademyId(int academyId) {
        return groupInfoRepository.findByAcademyAcademyId(academyId);
    }

    // TODO: refactor this
    // @Transactional
    // @Override
    // public List<AcademyDTO> findWithEmployeeExperts() {
    // List<Academy> academies = academyRepository.findWithEmployeeExperts();
    // List<AcademyDTO> academyDTOS = new ArrayList<>();
    // for(Academy academy: academies){
    // AcademyDTO academyDTO = academyConverter.toDTO(academy);
    // academyDTOS.add(academyDTO);
    // }
    // return academyDTOS;
    // }

}
