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
    private StudentsServiceImpl studentsServiceImpl;

    @Autowired
    private StudentsStatusesService studentsStatusesService;

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
        // int countStudentsInTheGroup = 0;
        List<GroupInfo> groupInfoList = findAll();
        List<AcademyDTO> academyDTOList = new ArrayList<>();
        List<LanguageTranslations> languageTranslations = languageTranslationsService.getAllLanguageTranslationsName();
        TeacherTypes teacherTypes = teacherTypeService.findOne(EXPERT_STATUS_ID);
        StudentStatuses studentStatuses = studentsStatusesService.findOne(TRAINEE_STATUS_ID);
        List<GroupInfoTeachers> getExpertsOfTheGroup = groupInfoTeachersService.findAllByTeacherType(teacherTypes);

        // List<Students> studentsList = studentsService.findAllByStudentStatus(studentStatuses);

        // long l = System.currentTimeMillis();
        for (GroupInfo groupInfo : groupInfoList) {
            AcademyDTO academyDTO = academyConverter.toDTO(groupInfo);
            if (groupInfo.getAcademy() != null) {
                if (groupInfo.getAcademy().getCity() != null) {
                    for (LanguageTranslations languageTranslation : languageTranslations) {
                        if (languageTranslation.getItemId() == groupInfo.getAcademy().getCity().getCityId()) {
                            academyDTO.setCityName(languageTranslation.getTrasnlation());
                            break;
                        }
                    }
                }
                if (groupInfo.getAcademy().getAcademyStages() != null) {
                    academyDTO.setStatus(groupInfo.getAcademy().getAcademyStages().getName());
                }
                List<String> employeeList = new ArrayList<>();
                for (GroupInfoTeachers groupInfoTeachers : getExpertsOfTheGroup) {
                    if (groupInfoTeachers.getAcademy().getAcademyId() == groupInfo.getAcademy().getAcademyId()) {
                        employeeList.add(groupInfoTeachers.getEmployee().getFirstNameEng() + " "
                                + groupInfoTeachers.getEmployee().getLastNameEng());
                        break;
                    }
                }
                academyDTO.setExperts(employeeList);
                /*
                 * for (Students students : studentsList) { if (students.getAcademy() != null) { if
                 * (students.getAcademy().getAcademyId() == groupInfo.getAcademy().getAcademyId()) {
                 * countStudentsInTheGroup++; } } }
                 */
                Integer countActualStudents = studentsServiceImpl
                        .countAllByAcademyAndStudentStatus(groupInfo.getAcademy(), studentStatuses);
                academyDTO.setStudentsActual(countActualStudents);
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
        academyDTO.setCityNames(languageTranslations);
        academyDTOList.add(academyDTO);
        return academyDTOList;
    }

    @Override
    public List<GroupInfo> findAll() {
        return groupInfoRepository.findAll();
    }

    @Override
    public GroupInfo findOneGroupInfoByAcademyId(int academyId) {
        return groupInfoRepository.findByAcademyAcademyId(academyId);
    }
}
