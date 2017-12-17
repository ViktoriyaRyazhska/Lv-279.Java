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

import java.util.*;
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
    private StudentRepository studentRepository;
    @Autowired
    private GroupInfoTeachersRepository groupInfoTeachersRepository;

    private static int TRUE = 1;
    private static int FALSE = 0;

    private enum Key {
        ENGLISH_LEVEL_DEFINED(Category.GROUP_STARTED_SUCCESSFULLY),
        ENGLISH_LEVEL_CORRECT(Category.GROUP_STARTED_SUCCESSFULLY),
        ENTRY_SCORE_DEFINED(Category.GROUP_STARTED_SUCCESSFULLY),
        INCOMING_TEST_DEFINED(Category.GROUP_STARTED_SUCCESSFULLY),
        APPROVED_BY_DEFINED(Category.GROUP_STARTED_SUCCESSFULLY),
        TEACHER_DEFINED(Category.GROUP_STARTED_SUCCESSFULLY),
        EXPERT_DEFINED(Category.GROUP_STARTED_SUCCESSFULLY),
        GROUP_STARTED_SUCCESSFULLY(Category.NO_CATEGORY),

        TEST1(Category.GROUP_READY_TO_OFFERING),
        TEST2(Category.GROUP_READY_TO_OFFERING),
        TEST3(Category.GROUP_READY_TO_OFFERING),
        TEST4(Category.GROUP_READY_TO_OFFERING),
        TEST5(Category.GROUP_READY_TO_OFFERING),
        INTERMEDIATE_TEST_BASE_PASS(Category.GROUP_READY_TO_OFFERING),
        INTERMEDIATE_TEST_LANG_PASS(Category.GROUP_READY_TO_OFFERING),
        TEACHER_FEEDBACKS_FILLED_IN(Category.GROUP_READY_TO_OFFERING),
        EXPERT_FEEDBACKS_FILLED_IN(Category.GROUP_READY_TO_OFFERING),
        GROUP_READY_TO_OFFERING(Category.NO_CATEGORY),

        FINAL_TEST_BASE_PASS(Category.GROUP_READY_FOR_CLOSE),
        FINAL_TEST_LANG_PASS(Category.GROUP_READY_FOR_CLOSE),
        INTERVIEWER_DEFINED(Category.GROUP_READY_FOR_CLOSE),
        INTERVIEWER_SUMMARY_DEFINED(Category.GROUP_READY_FOR_CLOSE),
        EXPERTS_LOAD_FILLED_IN(Category.GROUP_READY_FOR_CLOSE),
        INTERVIEWERS_LOAD_FILLED_IN(Category.GROUP_READY_FOR_CLOSE),
        GROUP_READY_FOR_CLOSE(Category.NO_CATEGORY),

        TEST6(Category.NO_CATEGORY),
        TEST7(Category.NO_CATEGORY),
        TEST8(Category.NO_CATEGORY),
        TEST9(Category.NO_CATEGORY),
        TEST10(Category.NO_CATEGORY);

        private Category category;

        Key(Category category) {
            this.category = category;
        }

        public static List<Key> getByCategory(Category category) {
            return Arrays
                    .stream(values())
                    .filter(key -> key.category == category)
                    .collect(Collectors.toList());
        }
    }

    private enum Category {
        GROUP_STARTED_SUCCESSFULLY,
        GROUP_READY_TO_OFFERING,
        GROUP_READY_FOR_CLOSE,
        NO_CATEGORY
    }

    @Override
    public List<CheckListByGroupsDto> getAllCheckListByGroupsDto() {

        List<Academy> allAcademies = academyRepository.findAll()
                .stream()
                .limit(30)
                .collect(Collectors.toList());

        List<CheckListByGroupsDto> CheckListByGroupsDtos = new ArrayList<>();

        for (Academy academy : allAcademies) {
            CheckListByGroupsDtos.add(getCheckListByGroupDtoByAcademy(academy));
        }
        return CheckListByGroupsDtos;
    }

    private CheckListByGroupsDto getCheckListByGroupDtoByAcademy(Academy academy) {
        Integer academyId = academy.getAcademyId();

        GroupInfo groupInfo = groupInfoRepository.findByAcademyAcademyId(academyId);

        City city = academy.getCity();
        String cityName = "";
        if (city != null) {
            cityName = languageTranslationsRepository.getOneCityNameTranslationByItemId(city.getCityId());
        }

        AcademyStages stage = academy.getAcademyStages();

        List<Student> students = studentRepository.findAllActiveStudents(academyId);

        CheckListByGroupsDto checkListByGroupsDto = new CheckListByGroupsDto();
        checkListByGroupsDto.setCityName(cityName);
        checkListByGroupsDto.setGroupName((groupInfo == null) ? null : groupInfo.getGroupName());
        checkListByGroupsDto.setStatus((stage != null) ? stage.getName() : "");
        setTeachers(academyId, checkListByGroupsDto);
        Map<String, Integer> report = checkListByGroupsDto.getReport();
        for (Map.Entry<Key, CheckPredicate<Student>> predicate : predicates.entrySet()) {
            report.put(
                    predicate.getKey().toString(),
                    predicate.getValue().check(students)
            );
        }

        setTotal(checkListByGroupsDto);
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
        Map<String, Integer> report = checkListByGroupsDto.getReport();
        checkListByGroupsDto.setTeachers(getTeachers(teachers));
        checkListByGroupsDto.setExperts(getTeachers(experts));
        report.put(Key.TEACHER_DEFINED.toString(), (teachers != null && !teachers.isEmpty()) ? TRUE : FALSE);
        report.put(Key.EXPERT_DEFINED.toString(), (experts != null && !experts.isEmpty()) ? TRUE : FALSE);
        report.put(Key.INTERVIEWER_DEFINED.toString(), (interviewers != null && !interviewers.isEmpty()) ? TRUE : FALSE);
        report.put(Key.EXPERTS_LOAD_FILLED_IN.toString(), checkTeachers(git -> git.getContributedHours() != null, experts));
        report.put(Key.INTERVIEWERS_LOAD_FILLED_IN.toString(), checkTeachers(git -> git.getContributedHours() != null, interviewers));
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

    private Integer checkTeachers(Predicate<GroupInfoTeachers> predicate, List<GroupInfoTeachers> groupInfoTeachers) {
        if (groupInfoTeachers == null || groupInfoTeachers.isEmpty()) {
            return FALSE;
        }
        for (GroupInfoTeachers git : groupInfoTeachers) {
            if (!predicate.test(git)) {
                return FALSE;
            }
        }
        return TRUE;
    }

    private void setTotal(CheckListByGroupsDto checkListByGroupsDto) {
        double sum = 0;
        Map<String, Integer> report = checkListByGroupsDto.getReport();
        for (Map.Entry s : report.entrySet()) {
            sum += (Integer) s.getValue();
        }
        checkListByGroupsDto.setTotal((double) Math.round((sum / report.size()) * 100 * 100) / 100);

        int flag = TRUE;
        for (Key key : Key.getByCategory(Category.GROUP_STARTED_SUCCESSFULLY)) {
            flag *= report.get(key.toString());
        }
        report.put(Key.GROUP_STARTED_SUCCESSFULLY.toString(), flag);
        if (flag == FALSE) {
            report.put(Key.GROUP_READY_TO_OFFERING.toString(), FALSE);
            report.put(Key.GROUP_READY_FOR_CLOSE.toString(), FALSE);
        } else {
            flag = TRUE;
            for (Key key : Key.getByCategory(Category.GROUP_READY_TO_OFFERING)) {
                flag *= report.get(key.toString());
            }
            report.put(Key.GROUP_READY_TO_OFFERING.toString(), flag);
            if (flag == FALSE) {
                report.put(Key.GROUP_READY_FOR_CLOSE.toString(), FALSE);
            } else {
                flag = TRUE;
                for (Key key : Key.getByCategory(Category.GROUP_READY_FOR_CLOSE)) {
                    flag *= report.get(key.toString());
                }
                report.put(Key.GROUP_READY_FOR_CLOSE.toString(), flag);
            }
        }

    }

    private static final Map<Key, CheckPredicate<Student>> predicates;

    static {
        predicates = new HashMap<>();
        predicates.put(Key.ENGLISH_LEVEL_DEFINED, student -> student.getData().getEnglishLevel() == null);
        predicates.put(Key.ENGLISH_LEVEL_CORRECT, student -> {
            EnglishLevel englishLevel = student.getData().getEnglishLevel();
            return englishLevel != null && englishLevel.getEnglishLevelId() < ENGLISH_LEVEL_PRE_INTERMEDIATE_ID;
        });
        predicates.put(Key.ENTRY_SCORE_DEFINED, student -> student.getData().getEntryScore() == null);
        predicates.put(Key.INCOMING_TEST_DEFINED, student -> student.getData().getIncomingTest() == null);
        predicates.put(Key.APPROVED_BY_DEFINED, student -> student.getApprovedBy() == null);
        predicates.put(Key.INTERMEDIATE_TEST_BASE_PASS, student -> student.getData().getIntermBase() == null);
        predicates.put(Key.INTERMEDIATE_TEST_LANG_PASS, student -> student.getData().getIntermLang() == null);
        predicates.put(Key.TEACHER_FEEDBACKS_FILLED_IN,
                student -> student.getTeacherFeedback() == null && student.getData().getTeacherScore() == null);
        predicates.put(Key.EXPERT_FEEDBACKS_FILLED_IN,
                student -> student.getExpertFeedback() == null && student.getData().getExpertScore() == null);
        predicates.put(Key.FINAL_TEST_BASE_PASS, student -> student.getData().getFinalBase() == null);
        predicates.put(Key.FINAL_TEST_LANG_PASS, student -> student.getData().getFinalLang() == null);
        predicates.put(Key.INTERVIEWER_SUMMARY_DEFINED, student -> student.getData().getInterviewerComment() == null);
        predicates.put(Key.TEST1, student -> student.getData().getTestOne() == null);
        predicates.put(Key.TEST2, student -> student.getData().getTestTwo() == null);
        predicates.put(Key.TEST3, student -> student.getData().getTestThree() == null);
        predicates.put(Key.TEST4, student -> student.getData().getTestFour() == null);
        predicates.put(Key.TEST5, student -> student.getData().getTestFive() == null);
        predicates.put(Key.TEST6, student -> student.getData().getTestSix() == null);
        predicates.put(Key.TEST7, student -> student.getData().getTestSeven() == null);
        predicates.put(Key.TEST8, student -> student.getData().getTestEight() == null);
        predicates.put(Key.TEST9, student -> student.getData().getTestNine() == null);
        predicates.put(Key.TEST10, student -> student.getData().getTestTen() == null);
    }

    public interface CheckPredicate<T> {
        boolean test(T t);

        default Integer check(List<T> list) {
            if (list == null || list.isEmpty()) {
                return FALSE;
            }
            boolean testResult = list
                    .stream()
                    .anyMatch(this::test);
            return (!testResult) ? TRUE : FALSE;
        }
    }
}
