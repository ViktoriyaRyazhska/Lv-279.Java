package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.AcademyConverter;
import ua.softserve.service.dto.AcademyDTO;

import java.util.ArrayList;
import java.util.List;

/**
 * Service processes information that returns Repositories.
 */
@Service
public class GroupInfoServiceImpl implements GroupInfoService {
    private static final int EXPERT_STATUS_ID = 2;
    private static final int TRAINEE_STATUS_ID = 1;

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
    public List<AcademyDTO> getAllAcademies() {
        List<GroupInfo> groupInfoList = findAllWithOrder();
        List<AcademyDTO> academyDTOList = new ArrayList<>();
        Integer countActualStudents = null;
        List<GroupInfoTeachers> getExpertsOfTheGroup = null;
        List<LanguageTranslations> languageTranslations = languageTranslationsService.getAllLanguageTranslationsName();
        TeacherTypes teacherTypes = teacherTypeService.findOne(EXPERT_STATUS_ID);
        StudentStatuses studentStatuses = studentsStatusesService.findOne(TRAINEE_STATUS_ID);
        if (teacherTypes != null) {
            getExpertsOfTheGroup = groupInfoTeachersService.findAllByTeacherType(teacherTypes);
        }
        if (groupInfoList != null) {


            for (GroupInfo groupInfo : groupInfoList) {
                AcademyDTO academyDTO = academyConverter.toDTO(groupInfo);
                Academy academy = groupInfo.getAcademy();
                if (academy != null) {
                    if (academy.getCity() != null) {
                        for (LanguageTranslations languageTranslation : languageTranslations) {
                            if (languageTranslation.getItemId() == academy.getCity().getCityId()) {
                                academyDTO.setCityName(languageTranslation.getTrasnlation());
                                break;
                            }
                        }
                    }
                    if (academy.getAcademyStages() != null) {
                        academyDTO.setStatus(academy.getAcademyStages().getName());
                    }
                    List<String> employeeList = new ArrayList<>();
                    if (getExpertsOfTheGroup != null) {
                        for (GroupInfoTeachers groupInfoTeachers : getExpertsOfTheGroup) {
                            if (groupInfoTeachers.getAcademy().getAcademyId() == academy.getAcademyId()) {
                                employeeList.add(groupInfoTeachers.getEmployee().getFirstNameEng() + " "
                                        + groupInfoTeachers.getEmployee().getLastNameEng());
                            }
                        }
                    }
                    if(employeeList.size() != 0){
                        academyDTO.setExperts(employeeList);
                    }
                    if (studentStatuses != null) {
                        countActualStudents = studentsService
                                .countAllByAcademyAndStudentStatus(academy, studentStatuses);
                    }
                    if (countActualStudents != null) {
                        academyDTO.setStudentsActual(countActualStudents);
                    }
                }
                if (groupInfo.getProfileInfo() != null) {
                    academyDTO.setProfileName(groupInfo.getProfileInfo().getProfileName());
                }
                academyDTOList.add(academyDTO);
            }
        }

        AcademyDTO academyDTO = new AcademyDTO();
        academyDTO.setAcademyStages(academyStagesService.getAllAcademyStagesService());
        academyDTO.setDirection(directionService.findAllDirectionsInIta());
        academyDTO.setTechnologie(technologyServiceImpl.findAllTechonologyInIta());
        academyDTO.setProfile(profileService.findAll());
        academyDTO.setCityNames(languageTranslations);
        academyDTOList.add(academyDTO);
        return academyDTOList;
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
