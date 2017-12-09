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
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.persistence.repo.GroupInfoTeachersRepository;
import ua.softserve.persistence.repo.LanguageTranslationsRepository;
import ua.softserve.persistence.repo.StudentRepository;
import ua.softserve.service.AcademyStagesService;
import ua.softserve.service.CheckListByGroupsDtoService;
import ua.softserve.service.GroupInfoService;
import ua.softserve.service.dto.CheckListByGroupsDto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CheckListByGroupsDtoServiceImpl implements CheckListByGroupsDtoService {
    @Autowired
    private AcademyRepository academyacademyRepository;
    @Autowired
    private GroupInfoService groupInfoService;
    @Autowired
    private LanguageTranslationsRepository languageTranslationsRepository;
    @Autowired
    private AcademyStagesService academyStagesService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private GroupInfoTeachersRepository groupInfoTeachersRepository;


    @Override
    public List<CheckListByGroupsDto> getAllCheckListByGroupsDto() {
        List<Academy> allAcademies = academyacademyRepository.findAll()
                .stream()
                .filter(academy -> academy.getAcademyId() >= 624 && academy.getAcademyId() <= 650)
                .collect(Collectors.toList());
        List<CheckListByGroupsDto> checkListByGroupsDtos = new ArrayList<>();
        for (Academy academy : allAcademies) {
            CheckListByGroupsDto checkListByGroupsDto = new CheckListByGroupsDto();
            GroupInfo groupInfo =
                    groupInfoService
                            .findOneGroupInfoByAcademyId(academy.getAcademyId());
            checkListByGroupsDto.setGroupName((groupInfo == null) ? null : groupInfo.getGroupName());

//            LanguageTranslations city = languageTranslationsRepository
//                    .findByItemIdAndLanguageLanguageIdAndTag(academy.getCity().getCityId(), 2, "city");
//            checkListByGroupsDto.setCityName((city == null)?null:city.getTrasnlation());
            String city = languageTranslationsRepository.getOneCityNameTranslationByItemId(academy.getCity().getCityId());
            checkListByGroupsDto.setCityName(city);

            checkListByGroupsDto.setStartDate(academy.getStartDate());
            checkListByGroupsDto.setEndDate(academy.getEndDate());

            AcademyStages stage = academyStagesService.findOne(academy.getAcademyStages().getStageId());
            checkListByGroupsDto.setStatus(stage.getName());
            List<Student> students = studentRepository.findAllByAcademy_AcademyId(academy.getAcademyId());
            List<CheckListByGroupsDto.StudentInGroup> studentsInGroup = new ArrayList<>();
            for (Student student : students) {
                CheckListByGroupsDto.StudentInGroup studentInGroup = checkListByGroupsDto.new StudentInGroup();

                studentInGroup.setEntryScore(student.getData().getEntryScore());

                studentInGroup.setStatus(student.getStudentStatus().getName());

                studentInGroup.setApprovedBy(student.getApprovedBy().getFirstNameEng() + " " +
                        student.getApprovedBy().getLastNameEng());

                studentInGroup.setEnglishLevel(student.getData().getEnglishLevel().getName());

                List<GroupInfoTeachers> groupInfoTeachers =
                        groupInfoTeachersRepository.findAllByAcademy_AcademyId(academy.getAcademyId());
                List<CheckListByGroupsDto.TeacherInGroup> teachersInGroup = new ArrayList<>();

                for (GroupInfoTeachers git : groupInfoTeachers) {
                    CheckListByGroupsDto.TeacherInGroup teacherInGroup = checkListByGroupsDto.new TeacherInGroup();
                    Employee teacher = git.getEmployee();

                    teacherInGroup.setFullName(teacher.getFirstNameEng() + " " + teacher.getLastNameEng());
                    teacherInGroup.setLoad(git.getInvolved());
                    String ttName = git.getTeacherType().getName();
                    CheckListByGroupsDto.TeacherTypes teacherTypes
                            = CheckListByGroupsDto.TeacherTypes.valueOf(ttName.toUpperCase());
                    teacherInGroup.setType(teacherTypes);

                    CheckListByGroupsDto.Feedback feedback = checkListByGroupsDto.new Feedback();

                    Feedback teacherFeedback = student.getTeacherFeedback();
                    feedback.setActiveCommunicator(teacherFeedback.getActiveCommunicator().getName());
                    feedback.setGettingThingsDone(teacherFeedback.getGettingThingsDone().getName());
                    feedback.setLearningAbility(teacherFeedback.getLearningAbility().getName());
                    feedback.setOverallTechnicalCompetence(teacherFeedback.getOverallTechnicalCompetence().getName());
                    feedback.setPassionalInitiative(teacherFeedback.getPassionalInitiative().getName());
                    feedback.setTeamWork(teacherFeedback.getTeamWork().getName());
                    feedback.setSummary(teacherFeedback.getSummary());

                    studentInGroup.setTeacherFeedback(feedback);
                    feedback = checkListByGroupsDto.new Feedback();

                    Feedback expertFeedback = student.getExpertFeedback();
                    feedback.setActiveCommunicator(expertFeedback.getActiveCommunicator().getName());
                    feedback.setGettingThingsDone(expertFeedback.getGettingThingsDone().getName());
                    feedback.setLearningAbility(expertFeedback.getLearningAbility().getName());
                    feedback.setOverallTechnicalCompetence(expertFeedback.getOverallTechnicalCompetence().getName());
                    feedback.setPassionalInitiative(expertFeedback.getPassionalInitiative().getName());
                    feedback.setTeamWork(expertFeedback.getTeamWork().getName());
                    feedback.setSummary(expertFeedback.getSummary());

                    studentInGroup.setExpertFeedback(feedback);
                    teachersInGroup.add(teacherInGroup);

                }

                checkListByGroupsDto.setTeachers(teachersInGroup);

                CheckListByGroupsDto.TestsOfStudent testsOfStudent = checkListByGroupsDto.new TestsOfStudent();
                testsOfStudent.setFinalTestBase(student.getData().getFinalBase());
                testsOfStudent.setFinalTestLang(student.getData().getFinalLang());
                testsOfStudent.setIncomingTest(student.getData().getIncomingTest());
                testsOfStudent.setIntermediateTestBase(student.getData().getIntermBase());
                testsOfStudent.setIntermediateTestLang(student.getData().getIntermLang());
                double testsN[] = new double[10];
                testsN[0] = student.getData().getTestOne();
                testsN[1] = student.getData().getTestTwo();
                testsN[2] = student.getData().getTestThree();
                testsN[3] = student.getData().getTestFour();
                testsN[4] = student.getData().getTestFive();
                testsN[5] = student.getData().getTestSix();
                testsN[6] = student.getData().getTestSeven();
                testsN[7] = student.getData().getTestEight();
                testsN[8] = student.getData().getTestNine();
                testsN[9] = student.getData().getTestTen();
                testsOfStudent.setTestN(testsN);
                studentInGroup.setTestsOfStudent(testsOfStudent);

                studentsInGroup.add(studentInGroup);
            }
            checkListByGroupsDto.setStudents(studentsInGroup);

            checkListByGroupsDtos.add(checkListByGroupsDto);
        }
        return checkListByGroupsDtos;
    }

//    @Override
//    public List<CheckListByGroupsDto> fakeGetAllCheckListByGroupsDto(int count) {
//        List<CheckListByGroupsDto> listByGroupsDtos = new ArrayList<>();
//        for (int i = 0; i < count; i++) {
//            CheckListByGroupsDto checkListByGroupsDto = getRandomGroup();
//            int teachersCount = (Math.random() < 0.85) ? 1 : 2;
//            int expertsCount = (Math.random() < 0.85) ? 1 : 2;
//            int interviewersCount = (Math.random() < 0.85) ? 1 : 2;
//            checkListByGroupsDto.setTeachers(getRandomTeachersInGroup(teachersCount, expertsCount, interviewersCount));
//            checkListByGroupsDto.setStudents(getRandomStudentsInGroup(teachersCount, expertsCount, interviewersCount));
//            listByGroupsDtos.add(checkListByGroupsDto);
//        }
//        return listByGroupsDtos;
//    }

//    private CheckListByGroupsDto getRandomGroup() {
//        CheckListByGroupsDto checkListByGroupsDto = new CheckListByGroupsDto();
//
//        checkListByGroupsDto.setCityName(getRandomCity());
//        Date startDate = getRandomDateBetween(new Date(System.currentTimeMillis() - ONE_MONTH_IN_MILES * 6),
//                new Date(System.currentTimeMillis() + ONE_MONTH_IN_MILES * 6));
//        checkListByGroupsDto.setStartDate(startDate);
//        checkListByGroupsDto.setEndDate(new Date(startDate.getTime() + ONE_MONTH_IN_MILES * 3));
//        checkListByGroupsDto.setGroupName(getRandomGroupNameByCity(checkListByGroupsDto.getCityName()));
//        checkListByGroupsDto.setStatus(getRandomGroupStatus());
//        return checkListByGroupsDto;
//    }
//
//    private CheckListByGroupsDto.TeacherInGroup getRandomTeacherInGroup(CheckListByGroupsDto.TeacherTypes type,
//            int teachersCount) {
//        CheckListByGroupsDto.TeacherInGroup teacherInGroup = new CheckListByGroupsDto().new TeacherInGroup();
//        RandomPerson randomPerson = RandomPersonGenerator.getRandomPerson();
//        teacherInGroup.setFullName(randomPerson.getFirstName() + " " + randomPerson.getLastName());
//        teacherInGroup.setLoad(100 / teachersCount);
//        teacherInGroup.setType(type);
//        return teacherInGroup;
//    }
//
//    private List<CheckListByGroupsDto.TeacherInGroup> getRandomTeachersInGroup(int teachersCount, int expertsCount,
//            int interviewersCount) {
//        List<CheckListByGroupsDto.TeacherInGroup> teachers = new ArrayList<>();
//        for (int c = 0; c < teachersCount; c++) {
//            teachers.add(getRandomTeacherInGroup(CheckListByGroupsDto.TeacherTypes.TEACHER, teachersCount));
//        }
//        for (int c = 0; c < expertsCount; c++) {
//            teachers.add(getRandomTeacherInGroup(CheckListByGroupsDto.TeacherTypes.EXPERT, expertsCount));
//        }
//        for (int c = 0; c < interviewersCount; c++) {
//            teachers.add(getRandomTeacherInGroup(CheckListByGroupsDto.TeacherTypes.INTERVIEWER, interviewersCount));
//        }
//        return teachers;
//    }

//    private List<CheckListByGroupsDto.StudentInGroup> getRandomStudentsInGroup(int teachersCount, int expertsCount,
//            int interviewersCount) {
//        List<CheckListByGroupsDto.StudentInGroup> students = new ArrayList<>();
//        int studentsCount = getRandomStudentsCount();
//        RandomPerson randomPerson = RandomPersonGenerator.getRandomPerson();
//        String approvedBy = randomPerson.getFirstName() + " " + randomPerson.getLastName();
//        for (int j = 0; j < studentsCount; j++) {
//
//            CheckListByGroupsDto.StudentInGroup studentInGroup = new CheckListByGroupsDto().new StudentInGroup();
//            studentInGroup.setApprovedBy(approvedBy);
//            studentInGroup.setEnglishLevel(getRandomCorrectEnglishLevel());
//            studentInGroup.setEntryScore(getRandomDouble(300, 1000));
//            studentInGroup.setStatus(getRandomStudentStatus());
//
//            List<CheckListByGroupsDto.TeacherOfStudent> teachersOfStudent = new ArrayList<>();
//            for (int c = 0; c < teachersCount + expertsCount; c++) {
//                CheckListByGroupsDto.TeacherOfStudent teacherOfStudent = new CheckListByGroupsDto().new TeacherOfStudent();
//                teacherOfStudent.setScore(getRandomDouble(3, 5));
//                List<String> randomFeedbacks = getRandomFeedbacks();
//                teacherOfStudent.setEnumeratedFeedbacks(randomFeedbacks);
//                StringBuilder summary = new StringBuilder();
//                for (String s : randomFeedbacks) {
//                    if (s.length() > 1) {
//                        summary.append(s.toUpperCase().charAt(0)).append(s.toLowerCase().substring(1)).append(" ");
//                    } else {
//                        summary.append(s).append(" ");
//                    }
//
//                }
//                teacherOfStudent.setSummary(summary.toString().trim());
//                teachersOfStudent.add(teacherOfStudent);
//            }
//
//            for (int c = 0; c < interviewersCount; c++) {
//                CheckListByGroupsDto.TeacherOfStudent teacherOfStudent = new CheckListByGroupsDto().new TeacherOfStudent();
//                teacherOfStudent.setScore(getRandomDouble(3, 5));
//                teacherOfStudent.setSummary("Bla bla bla");
//                teachersOfStudent.add(teacherOfStudent);
//            }
//
//            studentInGroup.setTeachersOfStudent(teachersOfStudent);
//
//            CheckListByGroupsDto.TestsOfStudent testsOfStudent = new CheckListByGroupsDto().new TestsOfStudent();
//            double[] testsN = new double[10];
//            for (int c = 0; c < 10; c++) {
//                double min = (Math.random() < 0.5) ? 3 : 300;
//                double max = (min == 3) ? 10 : 1000;
//                testsN[c] = getRandomDouble(min, max);
//            }
//            testsOfStudent.setTestN(testsN);
//            testsOfStudent.setIncomingTest(getRandomDouble(300, 1000));
//            testsOfStudent.setIntermediateTestBase(getRandomDouble(300, 1000));
//            testsOfStudent.setIntermediateTestLang(getRandomDouble(300, 1000));
//            testsOfStudent.setFinalTestBase(getRandomDouble(300, 1000));
//            testsOfStudent.setFinalTestLang(getRandomDouble(300, 1000));
//            studentInGroup.setTestsOfStudent(testsOfStudent);
//
//            students.add(studentInGroup);
//        }
//        return students;
//    }
}
