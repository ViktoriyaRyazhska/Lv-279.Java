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


    @Override
    public List<CheckListByGroupsDto> getAllCheckListByGroupsDto() {

        List<Academy> allAcademies = academyRepository.findAll()
                .stream()
                .filter(academy -> academy.getAcademyId() >= 586 && academy.getAcademyId() <= 932)
                .limit(20)
                .collect(Collectors.toList());

        List<CheckListByGroupsDto> CheckListByGroupsDtos = new ArrayList<>();

        for (Academy academy : allAcademies) {

            Integer academyId = academy.getAcademyId();
            CheckListByGroupsDto checkListByGroupsDto;
            GroupInfo groupInfo;
            String city;
            AcademyStages stage;
            List<Student> students;
            List<GroupInfoTeachers> teachers;
            List<GroupInfoTeachers> experts;
            List<GroupInfoTeachers> interviewers;
            List<CheckListByGroupsDto.TeacherInGroup> teachersInGroup;
            CheckListByGroupsDto.TeacherInGroup teacherInGroup;

            groupInfo = groupInfoRepository
                    .findByAcademyAcademyId(academyId);

            city = languageTranslationsRepository
                    .getOneCityNameTranslationByItemId(academy.getCity().getCityId());

            stage = academyStagesRepository
                    .findOne(academy.getAcademyStages().getStageId());

            students = studentRepository
                    .findAllByAcademy_AcademyId(academyId);

            teachers = groupInfoTeachersRepository
                    .findAllByAcademyIdAndTeacherTypeId(academyId, TT_TEACHER_ID);

            experts = groupInfoTeachersRepository
                    .findAllByAcademyIdAndTeacherTypeId(academyId, TT_EXPERT_ID);

            interviewers = groupInfoTeachersRepository
                    .findAllByAcademyIdAndTeacherTypeId(academyId, TT_INTERVIEWER_ID);

            teachersInGroup = new ArrayList<>();

            checkListByGroupsDto = new CheckListByGroupsDto();
            checkListByGroupsDto.setCityName(city);
            checkListByGroupsDto.setGroupName(
                    (groupInfo == null) ? null : groupInfo.getGroupName()
            );
            checkListByGroupsDto.setStatus(stage.getName());
            if (teachers != null) {
                for (GroupInfoTeachers git : teachers) {
                    teacherInGroup = checkListByGroupsDto.new TeacherInGroup();
                    teacherInGroup.setFullName(
                            git.getEmployee().getFirstNameEng() + " " +
                                    git.getEmployee().getLastNameEng()
                    );
                    teacherInGroup.setTeacherType("Teacher");
                    teachersInGroup.add(teacherInGroup);
                }
            }
            if (experts != null) {
                for (GroupInfoTeachers git : experts) {
                    teacherInGroup = checkListByGroupsDto.new TeacherInGroup();
                    teacherInGroup.setFullName(
                            git.getEmployee().getFirstNameEng() + " " +
                                    git.getEmployee().getLastNameEng()
                    );
                    teacherInGroup.setTeacherType("Expert");
                    teachersInGroup.add(teacherInGroup);
                }
            }
            checkListByGroupsDto.setTeachers(teachersInGroup);
            Map<String, Integer> r = checkListByGroupsDto.getR();
            if (checkStudents(
                    student -> student.getData().getEnglishLevel() != null,
                    students ) == 1) {
                r.put("englishLevelDefined",1);
                r.put("englishLevelCorrect", checkStudents(
                        student -> student.getData()
                                .getEnglishLevel()
                                .getEnglishLevelId() >= EL_PRE_INTERMEDIATE_ID,
                        students
                ));
            } else {
                r.put("englishLevelDefined",0);
                r.put("englishLevelCorrect",0);
            }
            r.put("entryScoreDefined", checkStudents(
                            student -> student
                                    .getData()
                                    .getEntryScore() != null,
                            students
            ));
            r.put("incomingTestDefined", checkStudents(
                            student -> student
                                    .getData()
                                    .getIncomingTest() != null,
                            students
            ));
            r.put("approvedByDefined", checkStudents(
                            student -> student
                                    .getApprovedBy() != null,
                            students
            ));
            r.put("teacherDefined", (teachers != null)?1:0);
            r.put("expertDefined", (experts != null)?1:0);
            checkStudentsTestsNPass(students, r);
            r.put("intermediateTestBasePass", checkStudents(
                            student -> student.getData().getIntermBase() != null,
                            students
            ));
            r.put("intermediateTestLangPass", checkStudents(
                            student -> student.getData().getIntermLang() != null,
                            students
            ));
            r.put("teacherFeedbacksFilledIn",
                    checkStudents(
                            student -> student.getTeacherFeedback() != null,
                            students
                    ) * checkStudents(
                            student -> student.getData().getTeacherScore() != null,
                            students
                    )
            );
            r.put("expertFeedbacksFilledIn",
                    checkStudents(
                            student -> student.getExpertFeedback() != null,
                            students
                    ) * checkStudents(
                            student -> student.getData().getExpertScore() != null,
                            students
                    )
            );
            r.put("finalTestBasePass", checkStudents(
                            student -> student.getData().getFinalBase() != null,
                            students
            ));
            r.put("finalTestLangPass", checkStudents(
                            student -> student.getData().getFinalLang() != null,
                            students
            ));
            r.put("interviewerDefined", (interviewers != null)?1:0);
            r.put("interviewerSummaryDefined", checkStudents(
                            student -> student.getData().getInterviewerComment() != null,
                            students
            ));
            r.put("expertsLoadFilledIn", checkTeachers(
                            git -> git.getContributedHours() != null,
                            experts
            ));
            r.put("interviewersLoadFilledIn", checkTeachers(
                            git -> git.getContributedHours() != null,
                            interviewers
            ));
            checkListByGroupsDto.setTotal();
            CheckListByGroupsDtos.add(checkListByGroupsDto);
        }
        return CheckListByGroupsDtos;
    }

    private Integer checkStudents(Predicate<Student> predicate, List<Student> students) {
        if (students == null) {
            return 0;
        }
        for (Student student : students) {
            if (!checkStudentStatus(student)) {
                continue;
            }
            if (!predicate.test(student)) {
                return 0;
            }
        }
        return 1;
    }

    private Integer checkTeachers(Predicate<GroupInfoTeachers> predicate, List<GroupInfoTeachers> groupInfoTeachers) {
        if (groupInfoTeachers == null) {
            return 0;
        }
        for (GroupInfoTeachers git : groupInfoTeachers) {
            if (!predicate.test(git)) {
                return 0;
            }
        }
        return 1;
    }

    private boolean checkStudentStatus(Student student) {
        if (student == null || student.getStudentStatus() == null) {
            return false;
        }
        int id = student.getStudentStatus().getId();
        return id == SS_TRAINEE_ID ||
                id == SS_ACCEPTED_PRE_OFFER_ID ||
                id == SS_GRADUATED_ID;
    }

    private void checkStudentsTestsNPass(List<Student> students, Map<String, Integer> r) {
        r.put("test1", checkStudents(
                student -> student.getData().getTestOne() != null,
                students
        ));
        r.put("test2", checkStudents(
                student -> student.getData().getTestTwo() != null,
                students
        ));
        r.put("test3", checkStudents(
                student -> student.getData().getTestThree() != null,
                students
        ));
        r.put("test4", checkStudents(
                student -> student.getData().getTestFour() != null,
                students
        ));
        r.put("test5", checkStudents(
                student -> student.getData().getTestFive() != null,
                students
        ));
        r.put("test6", checkStudents(
                student -> student.getData().getTestSix() != null,
                students
        ));
        r.put("test7", checkStudents(
                student -> student.getData().getTestSeven() != null,
                students
        ));
        r.put("test8", checkStudents(
                student -> student.getData().getTestEight() != null,
                students
        ));
        r.put("test9", checkStudents(
                student -> student.getData().getTestNine() != null,
                students
        ));
        r.put("test10", checkStudents(
                student -> student.getData().getTestTen() != null,
                students
        ));
    }
}
