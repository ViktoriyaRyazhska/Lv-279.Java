package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.*;
import ua.softserve.service.dto.ItaTacticalPlanByGroupStageDto;

import java.util.*;

import static ua.softserve.persistence.constants.ConstantsFromDb.*;

import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.persistence.repo.LanguageTranslationsRepository;
import ua.softserve.service.AcademyService;
import ua.softserve.service.ItaTacticalPlanByGroupStageDtoService;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItaTacticalPlanByGroupStageDtoServiceImpl implements ItaTacticalPlanByGroupStageDtoService {

    @Autowired
    AcademyService academyService;
    @Autowired
    LanguageTranslationsRepository languageTranslationsRepository;
    @Autowired
    GroupInfoRepository groupInfoRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TeacherTypeRepository teacherTypeRepository;
    @Autowired
    GroupInfoTeachersRepository groupInfoTeachersRepository;
    @Autowired
    EmployeeRepository employeeRepository;

    /**
     * Method transforms information about one academy from all tables into one DTO object designed for ITA Tactical
     * Plan by Group Stage.
     *
     * @param id
     *            (int) indicates which group to form DTO object designed for ITA Tactical Plan by Group Stage.
     * @return information about one academy from all tables into one DTO object designed for ITA Tactical Plan by Group
     *         Stage.
     */
    @Override
    public ItaTacticalPlanByGroupStageDto findById(int id) {
        ItaTacticalPlanByGroupStageDto dto = new ItaTacticalPlanByGroupStageDto();
        Academy academy = academyService.findOne(id);
        if (academy != null) {
            dto.setGroupId(id);
            dto.setStartDate(academy.getStartDate());
            dto.setEndDate(academy.getEndDate());
            dto.setPaymentSatus(academy.getFree() == 1 ? "Founded by Softserve" : "Open group");

            if (academy.getTechnologies() != null) {
                dto.setCG(academy.getTechnologies().getName());
            } else {
                dto.setCG(null);
            }
            if (academy.getCity() != null) {
                dto.setLocation(languageTranslationsRepository
                        .getOneCityNameTranslationByItemId(academy.getCity().getCityId()));
            } else {
                dto.setLocation(null);
            }

            if (academy.getAcademyStages() != null) {
                dto.setGroupStatus(academy.getAcademyStages().getName());
            } else {
                dto.setGroupStatus(null);
            }
            GroupInfo academyInfo = groupInfoRepository.findByAcademyAcademyId(academy.getAcademyId());
            if (academyInfo != null) {
                dto.setGroupName(academyInfo.getGroupName());
                dto.setRequested(academyInfo.getStudentsPlannedToGraduate());
                ProfileInfo profileInfo = groupInfoRepository.findByAcademyAcademyId(academy.getAcademyId())
                        .getProfileInfo();
                if (profileInfo != null) {
                    dto.setProfile(profileInfo.getProfileName());
                } else {
                    dto.setProfile(null);
                }
            } else {
                dto.setGroupName(null);
                dto.setProfile(null);
                dto.setRequested(0);
            }
            this.calculationStudentsStatuses(dto);
            this.setTrainer(dto);
        } else {
            dto = null;
        }
        return dto;
    }

    /**
     * Method Generate data for weekly status meeting with GTA/HR/ITA partisipants. Contain list og available groups by
     * stages.
     *
     * @return List<List < ItaTacticalPlanByGroupStageDto>> with information from ITA Tactical Plan by Group Stage
     *         report.
     */
    @Override
    public List<List<ItaTacticalPlanByGroupStageDto>> itaTacticalPlanByGroupStageReport() {
        List<List<ItaTacticalPlanByGroupStageDto>> itaTacticalPlanByGroupStage = new ArrayList<List<ItaTacticalPlanByGroupStageDto>>();
        List<ItaTacticalPlanByGroupStageDto> planedGroupForTwoMoth = new ArrayList<>();
        List<ItaTacticalPlanByGroupStageDto> groupsInProces = new ArrayList<>();
        List<ItaTacticalPlanByGroupStageDto> groupsOffering = new ArrayList<>();
        List<ItaTacticalPlanByGroupStageDto> groupsGraduated = new ArrayList<>();
        List<ItaTacticalPlanByGroupStageDto> listOfPlannedReleases = new ArrayList<>();
        List<Academy> academies = academyService.getAllAcademies();
        Calendar dateForComparison = new GregorianCalendar();
        dateForComparison.add(Calendar.MONTH, 2);
        Calendar academyStartDate = new GregorianCalendar();
        for (Academy a : academies) {
            academyStartDate.setTimeInMillis(a.getStartDate().getTime());
            if ((a.getAcademyStages().getStageId() == ACADEMY_STAGE_PLANNED_ID)
                    && academyStartDate.before(dateForComparison)) {
                planedGroupForTwoMoth.add(this.findById(a.getAcademyId()));
            }
            if (a.getAcademyStages().getStageId() == ACADEMY_STAGE_IN_PROCESS_ID) {
                groupsInProces.add(this.findById(a.getAcademyId()));
            }
            if (a.getAcademyStages().getStageId() == ACADEMY_STAGE_OFFERING_ID) {
                groupsOffering.add(this.findById(a.getAcademyId()));
            }
            if (a.getAcademyStages().getStageId() == ACADEMY_STAGE_GRADUATED_ID) {
                groupsGraduated.add(this.findById(a.getAcademyId()));
            }
            if (a.getAcademyStages().getStageId() == ACADEMY_STAGE_BOARDING_ID) {
                listOfPlannedReleases.add(this.findById(a.getAcademyId()));
            }
        }
        itaTacticalPlanByGroupStage.add(planedGroupForTwoMoth);
        itaTacticalPlanByGroupStage.add(groupsInProces);
        itaTacticalPlanByGroupStage.add(groupsOffering);
        itaTacticalPlanByGroupStage.add(groupsGraduated);
        itaTacticalPlanByGroupStage.add(listOfPlannedReleases);
        return itaTacticalPlanByGroupStage;
    }

    /**
     * Method calculation information about student status in the group
     *
     * @param dto
     *            (ItaTacticalPlanByGroupStageDto) specifies which group to calculate the number of students with
     *            different statuses
     */
    private void calculationStudentsStatuses(ItaTacticalPlanByGroupStageDto dto) {
        List<Student> allStudentsOfGroup = studentRepository.findAllByAcademy_AcademyId(dto.getGroupId());
        int studentRequested = 0;
        for (Student student : allStudentsOfGroup) {
            if (student == null) {
                continue;
            }
            if (student.getStudentStatus() == null) {
                continue;
            }
            if (student.getStudentStatus().getId() == STUDENT_STATUS_TRAINEE_ID
                    || student.getStudentStatus().getId() == STUDENT_STATUS_TRAINEE_ID) {
                int currentValueStudentInProgress = dto.getStudyInProgress();
                dto.setStudyInProgress(++currentValueStudentInProgress);
            }
            if (student.getStudentStatus().getId() == STUDENT_STATUS_HIRED_ID) {
                int currentValueStudentHired = dto.getHired();
                dto.setStudyInProgress(++currentValueStudentHired);
            }
            studentRequested++;
        }
        dto.setRequested(studentRequested);
    }

    /**
     * Method search and transforms information about all teachers and experts of group into one StringBuilder object
     * and set into dto.
     *
     * @param dto
     *            indicates for which dto search, transforms and set information about trainers
     */

    private void setTrainer(ItaTacticalPlanByGroupStageDto dto) {
        TeacherTypes typeTeacher = teacherTypeRepository.findOne(TEACHER_TYPE_TEACHER_ID);
        TeacherTypes typeExpert = teacherTypeRepository.findOne(TEACHER_TYPE_EXPERT_ID);
        StringBuilder trainers = new StringBuilder();
        List<GroupInfoTeachers> allTeachersOfGroup = groupInfoTeachersRepository
                .findAllByAcademyAndTeacherType(academyService.getById(dto.getGroupId()), typeTeacher);
        List<GroupInfoTeachers> allExpertsOfGroup = groupInfoTeachersRepository
                .findAllByAcademyAndTeacherType(academyService.getById(dto.getGroupId()), typeExpert);
        for (GroupInfoTeachers teacherInfo : allTeachersOfGroup) {
            trainers.append(teacherInfo.getEmployee().getFirstNameEng() + " "
                    + teacherInfo.getEmployee().getLastNameEng() + ", ");
        }

        for (GroupInfoTeachers infoTeachers : allExpertsOfGroup) {
            trainers.append(infoTeachers.getEmployee().getFirstNameEng() + " "
                    + infoTeachers.getEmployee().getLastNameEng() + ", ");
        }

        dto.setTrainer(trainers);

    }
}
