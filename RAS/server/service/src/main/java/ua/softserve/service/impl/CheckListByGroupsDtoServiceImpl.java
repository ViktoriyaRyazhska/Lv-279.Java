/*
 * CheckListByGroupsDto2ServiceImpl
 *
 * Version 1.0-SNAPSHOT
 *
 * 03.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.*;
import ua.softserve.service.CheckListByGroupsDtoService;
import ua.softserve.service.dto.CheckListByGroupsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static ua.softserve.persistence.constants.ConstantsFromDb.*;
import static ua.softserve.service.dto.CheckListByGroupsDto.predicates;

@Service
public class CheckListByGroupsDtoServiceImpl implements CheckListByGroupsDtoService {
    @Autowired
    private AcademyRepository academyRepository;
    @Autowired
    private GroupInfoRepository groupInfoRepository;
    @Autowired
    private LanguageTranslationsRepository languageTranslationsRepository;
    @Autowired
    private AcademyStagesRepository academyStagesRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupInfoTeachersRepository groupInfoTeachersRepository;

    private static int TRUE = 1;
    private static int FALSE = 0;

    @Override
    public List<CheckListByGroupsDto> getAllCheckListByGroupsDto() {

        List<Academy> allAcademies = academyRepository.findAll().stream().limit(30).collect(Collectors.toList());

        List<CheckListByGroupsDto> CheckListByGroupsDtos = new ArrayList<>();

        for (Academy academy : allAcademies) {
            CheckListByGroupsDtos.add(getCheckListByGroupDtoByAcademy(academy));
        }
        return CheckListByGroupsDtos;
    }

    private CheckListByGroupsDto getCheckListByGroupDtoByAcademy(Academy academy) {
        Integer academyId = academy.getAcademyId();
        CheckListByGroupsDto checkListByGroupsDto;
        GroupInfo groupInfo;
        String city;
        AcademyStages stage;
        List<Student> students;

        groupInfo = groupInfoRepository.findByAcademyAcademyId(academyId);

        city = languageTranslationsRepository.getOneCityNameTranslationByItemId(academy.getCity().getCityId());

        stage = academyStagesRepository.findOne(academy.getAcademyStages().getStageId());

        students = studentRepository.findAllByAcademy_AcademyId(academyId);

        checkListByGroupsDto = new CheckListByGroupsDto();
        checkListByGroupsDto.setCityName(city);
        checkListByGroupsDto.setGroupName((groupInfo == null) ? null : groupInfo.getGroupName());
        checkListByGroupsDto.setStatus(stage.getName());
        setTeachers(academyId, checkListByGroupsDto);
        Map<String, Integer> r = checkListByGroupsDto.getR();
        for (Map.Entry predicate : predicates.entrySet()) {
            r.put((String) predicate.getKey(), checkStudents((Predicate<Student>) predicate.getValue(), students));
        }

        checkListByGroupsDto.setTotal();
        return checkListByGroupsDto;
    }

    private void setTeachers(Integer academyId, CheckListByGroupsDto checkListByGroupsDto) {
        List<GroupInfoTeachers> teachers = groupInfoTeachersRepository.findAllByAcademyIdAndTeacherTypeId(academyId,
                TEACHER_TYPE_TEACHER_ID);
        ;
        List<GroupInfoTeachers> experts = groupInfoTeachersRepository.findAllByAcademyIdAndTeacherTypeId(academyId,
                TEACHER_TYPE_EXPERT_ID);
        ;
        List<GroupInfoTeachers> interviewers = groupInfoTeachersRepository.findAllByAcademyIdAndTeacherTypeId(academyId,
                TEACHER_TYPE_INTERVIEWER_ID);
        Map<String, Integer> r = checkListByGroupsDto.getR();
        checkListByGroupsDto.setTeachers(getTeachers(teachers));
        checkListByGroupsDto.setExperts(getTeachers(experts));
        r.put("teacherDefined", (teachers != null) ? 1 : 0);
        r.put("expertDefined", (experts != null) ? 1 : 0);
        r.put("interviewerDefined", (interviewers != null) ? 1 : 0);
        r.put("expertsLoadFilledIn", checkTeachers(git -> git.getContributedHours() != null, experts));
        r.put("interviewersLoadFilledIn", checkTeachers(git -> git.getContributedHours() != null, interviewers));
    }

    private String getTeachers(List<GroupInfoTeachers> teachers) {
        StringBuilder teachersSb = new StringBuilder();
        if (teachers != null) {
            for (GroupInfoTeachers git : teachers) {
                teachersSb.append(git.getEmployee().getFirstNameEng()).append(" ")
                        .append(git.getEmployee().getLastNameEng()).append("; ");
            }
        }
        return teachersSb.toString();
    }

    private Integer checkStudents(Predicate<Student> predicate, List<Student> students) {
        if (students == null) {
            return FALSE;
        }
        for (Student student : students) {
            if (!checkStudentStatus(student)) {
                continue;
            }
            if (!predicate.test(student)) {
                return FALSE;
            }
        }
        return TRUE;
    }

    private Integer checkTeachers(Predicate<GroupInfoTeachers> predicate, List<GroupInfoTeachers> groupInfoTeachers) {
        if (groupInfoTeachers == null) {
            return FALSE;
        }
        for (GroupInfoTeachers git : groupInfoTeachers) {
            if (!predicate.test(git)) {
                return FALSE;
            }
        }
        return TRUE;
    }

    private boolean checkStudentStatus(Student student) {
        if (student == null || student.getStudentStatus() == null) {
            return false;
        }
        int id = student.getStudentStatus().getId();
        return id == STUDENT_STATUS_TRAINEE_ID || id == STUDENT_STATUS_ACCEPTED_PRE_OFFER_ID
                || id == STUDENT_STATUS_GRADUATED_ID;
    }
}
