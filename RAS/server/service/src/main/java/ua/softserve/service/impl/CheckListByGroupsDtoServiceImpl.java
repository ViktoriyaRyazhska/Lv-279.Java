/*
* CheckListByGroupsDtoServiceImpl
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
import ua.softserve.persistence.repo.LanguageTranslationsRepository;
import ua.softserve.persistence.repo.StudentsRepository;
import ua.softserve.service.*;
import ua.softserve.service.dto.CheckListByGroupsDto;
import ua.softserve.util.dump.random.RandomPerson;
import ua.softserve.util.dump.random.RandomPersonGenerator;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static ua.softserve.util.dump.random.RandomUtil.*;

@Service
public class CheckListByGroupsDtoServiceImpl implements CheckListByGroupsDtoService {
    @Autowired
    private AcademyService academyService;
    @Autowired
    private GroupInfoService groupInfoService;
    @Autowired
    private LanguageTranslationsRepository languageTranslationsRepository;
    @Autowired
    private AcademyStagesService academyStagesService;
    @Autowired
    private StudentsRepository studentsRepository;


    @Override
    public List<CheckListByGroupsDto> fakeGetAllCheckListByGroupsDto(int count) {
        List<CheckListByGroupsDto> listByGroupsDtos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            CheckListByGroupsDto checkListByGroupsDto = getRandomGroup();
            int teachersCount = (Math.random() < 0.85) ? 1 : 2;
            int expertsCount = (Math.random() < 0.85) ? 1 : 2;
            int interviewersCount = (Math.random() < 0.85) ? 1 : 2;
            checkListByGroupsDto.setTeachers(getRandomTeachersInGroup(teachersCount, expertsCount, interviewersCount));
            checkListByGroupsDto.setStudents(getRandomStudentsInGroup(teachersCount, expertsCount, interviewersCount));
            listByGroupsDtos.add(checkListByGroupsDto);
        }
        return listByGroupsDtos;
    }

    @Override
    public List<CheckListByGroupsDto> getAllCheckListByGroupsDto() {
        List<Academy> allAcademies = academyService.getAllAcademies();
        List<CheckListByGroupsDto> checkListByGroupsDtos = new ArrayList<>();
        for (Academy academy : allAcademies) {
            CheckListByGroupsDto checkListByGroupsDto = new CheckListByGroupsDto();
            GroupInfo groupInfo =
                    groupInfoService
                            .findOneGroupInfoByAcademyId(academy.getAcademyId());
            checkListByGroupsDto.setGroupName(groupInfo.getGroupName());

            LanguageTranslations city = languageTranslationsRepository
                    .findByItemIdAndLocal(academy.getCity().getCityId(), 'e');
            checkListByGroupsDto.setCityName(city.getTrasnlation());

            checkListByGroupsDto.setStartDate(academy.getStartDate());
            checkListByGroupsDto.setEndDate(academy.getEndDate());

            AcademyStages stage = academyStagesService.findOne(academy.getAcademyStages().getStageId());
            checkListByGroupsDto.setStatus(stage.getName());
            List<Students> students = studentsRepository.findAllByAcademy_AcademyId(academy.getAcademyId());
            List<CheckListByGroupsDto.StudentInGroup> studentsInGroup = new ArrayList<>();
            for (Students student : students) {
                CheckListByGroupsDto.StudentInGroup studentInGroup = checkListByGroupsDto.new StudentInGroup();

                studentInGroup.setEntryScore(student.getEntryScore());

                studentInGroup.setStatus(student.getStudentStatus().getName());

                studentInGroup.setApprovedBy(student.getApprovedBy().getFirstNameEng() + " " +
                        student.getApprovedBy().getLastNameEng());

                studentInGroup.setEnglishLevel(student.getEnglishLevel().getName());

                List<CheckListByGroupsDto.TeacherOfStudent> teachers = new ArrayList<>();

//                for ()
//                CheckListByGroupsDto.TeacherOfStudent teacherOfStudent = checkListByGroupsDto.new TeacherOfStudent();
//                teacherOfStudent.setEnumeratedFeedbacks();
//                teacherOfStudent.setScore();
//                teacherOfStudent.setSummary();
//                teachers.add(teacherOfStudent);
//
//                studentInGroup.setTeachersOfStudent(teachers);

//                CheckListByGroupsDto.TestsOfStudent testsOfStudent = checkListByGroupsDto.new TestsOfStudent();
//                testsOfStudent.setFinalTestBase();
//
//                studentInGroup.setTestsOfStudent();

                studentsInGroup.add(studentInGroup);
            }
            checkListByGroupsDto.setStudents(studentsInGroup);

            checkListByGroupsDtos.add(checkListByGroupsDto);
        }
        return checkListByGroupsDtos;
    }

    private CheckListByGroupsDto getRandomGroup() {
        CheckListByGroupsDto checkListByGroupsDto = new CheckListByGroupsDto();

        checkListByGroupsDto.setCityName(getRandomCity());
        Date startDate = getRandomDateBetween(new Date(System.currentTimeMillis() - ONE_MONTH_IN_MILES * 6),
                new Date(System.currentTimeMillis() + ONE_MONTH_IN_MILES * 6));
        checkListByGroupsDto.setStartDate(startDate);
        checkListByGroupsDto.setEndDate(new Date(startDate.getTime() + ONE_MONTH_IN_MILES * 3));
        checkListByGroupsDto.setGroupName(getRandomGroupNameByCity(checkListByGroupsDto.getCityName()));
        checkListByGroupsDto.setStatus(getRandomGroupStatus());
        return checkListByGroupsDto;
    }

    private CheckListByGroupsDto.TeacherInGroup getRandomTeacherInGroup(CheckListByGroupsDto.TeacherTypes type,
            int teachersCount) {
        CheckListByGroupsDto.TeacherInGroup teacherInGroup = new CheckListByGroupsDto().new TeacherInGroup();
        RandomPerson randomPerson = RandomPersonGenerator.getRandomPerson();
        teacherInGroup.setFullName(randomPerson.getFirstName() + " " + randomPerson.getLastName());
        teacherInGroup.setLoad(100 / teachersCount);
        teacherInGroup.setType(type);
        return teacherInGroup;
    }

    private List<CheckListByGroupsDto.TeacherInGroup> getRandomTeachersInGroup(int teachersCount, int expertsCount,
            int interviewersCount) {
        List<CheckListByGroupsDto.TeacherInGroup> teachers = new ArrayList<>();
        for (int c = 0; c < teachersCount; c++) {
            teachers.add(getRandomTeacherInGroup(CheckListByGroupsDto.TeacherTypes.TEACHER, teachersCount));
        }
        for (int c = 0; c < expertsCount; c++) {
            teachers.add(getRandomTeacherInGroup(CheckListByGroupsDto.TeacherTypes.EXPERT, expertsCount));
        }
        for (int c = 0; c < interviewersCount; c++) {
            teachers.add(getRandomTeacherInGroup(CheckListByGroupsDto.TeacherTypes.INTERVIEWER, interviewersCount));
        }
        return teachers;
    }

    private List<CheckListByGroupsDto.StudentInGroup> getRandomStudentsInGroup(int teachersCount, int expertsCount,
            int interviewersCount) {
        List<CheckListByGroupsDto.StudentInGroup> students = new ArrayList<>();
        int studentsCount = getRandomStudentsCount();
        RandomPerson randomPerson = RandomPersonGenerator.getRandomPerson();
        String approvedBy = randomPerson.getFirstName() + " " + randomPerson.getLastName();
        for (int j = 0; j < studentsCount; j++) {

            CheckListByGroupsDto.StudentInGroup studentInGroup = new CheckListByGroupsDto().new StudentInGroup();
            studentInGroup.setApprovedBy(approvedBy);
            studentInGroup.setEnglishLevel(getRandomCorrectEnglishLevel());
            studentInGroup.setEntryScore(getRandomDouble(300, 1000));
            studentInGroup.setStatus(getRandomStudentStatus());

            List<CheckListByGroupsDto.TeacherOfStudent> teachersOfStudent = new ArrayList<>();
            for (int c = 0; c < teachersCount + expertsCount; c++) {
                CheckListByGroupsDto.TeacherOfStudent teacherOfStudent = new CheckListByGroupsDto().new TeacherOfStudent();
                teacherOfStudent.setScore(getRandomDouble(3, 5));
                List<String> randomFeedbacks = getRandomFeedbacks();
                teacherOfStudent.setEnumeratedFeedbacks(randomFeedbacks);
                StringBuilder summary = new StringBuilder();
                for (String s : randomFeedbacks) {
                    if (s.length() > 1) {
                        summary.append(s.toUpperCase().charAt(0)).append(s.toLowerCase().substring(1)).append(" ");
                    } else {
                        summary.append(s).append(" ");
                    }

                }
                teacherOfStudent.setSummary(summary.toString().trim());
                teachersOfStudent.add(teacherOfStudent);
            }

            for (int c = 0; c < interviewersCount; c++) {
                CheckListByGroupsDto.TeacherOfStudent teacherOfStudent = new CheckListByGroupsDto().new TeacherOfStudent();
                teacherOfStudent.setScore(getRandomDouble(3, 5));
                teacherOfStudent.setSummary("Bla bla bla");
                teachersOfStudent.add(teacherOfStudent);
            }

            studentInGroup.setTeachersOfStudent(teachersOfStudent);

            CheckListByGroupsDto.TestsOfStudent testsOfStudent = new CheckListByGroupsDto().new TestsOfStudent();
            double[] testsN = new double[10];
            for (int c = 0; c < 10; c++) {
                double min = (Math.random() < 0.5) ? 3 : 300;
                double max = (min == 3) ? 10 : 1000;
                testsN[c] = getRandomDouble(min, max);
            }
            testsOfStudent.setTestN(testsN);
            testsOfStudent.setIncomingTest(getRandomDouble(300, 1000));
            testsOfStudent.setIntermediateTestBase(getRandomDouble(300, 1000));
            testsOfStudent.setIntermediateTestLang(getRandomDouble(300, 1000));
            testsOfStudent.setFinalTestBase(getRandomDouble(300, 1000));
            testsOfStudent.setFinalTestLang(getRandomDouble(300, 1000));
            studentInGroup.setTestsOfStudent(testsOfStudent);

            students.add(studentInGroup);
        }
        return students;
    }
}
