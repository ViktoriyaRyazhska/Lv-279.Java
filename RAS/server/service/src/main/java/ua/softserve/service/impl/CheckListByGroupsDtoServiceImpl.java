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

        TEST1(Category.GROUP_READY_TO_OFFERING),
        TEST2(Category.GROUP_READY_TO_OFFERING),
        TEST3(Category.GROUP_READY_TO_OFFERING),
        TEST4(Category.GROUP_READY_TO_OFFERING),
        TEST5(Category.GROUP_READY_TO_OFFERING),
        INTERMEDIATE_TEST_BASE_PASS(Category.GROUP_READY_TO_OFFERING),
        INTERMEDIATE_TEST_LANG_PASS(Category.GROUP_READY_TO_OFFERING),
        TEACHER_FEEDBACKS_FILLED_IN(Category.GROUP_READY_TO_OFFERING),
        EXPERT_FEEDBACKS_FILLED_IN(Category.GROUP_READY_TO_OFFERING),

        FINAL_TEST_BASE_PASS(Category.GROUP_READY_FOR_CLOSE),
        FINAL_TEST_LANG_PASS(Category.GROUP_READY_FOR_CLOSE),
        INTERVIEWER_DEFINED(Category.GROUP_READY_FOR_CLOSE),
        INTERVIEWER_SUMMARY_DEFINED(Category.GROUP_READY_FOR_CLOSE),
        EXPERTS_LOAD_FILLED_IN(Category.GROUP_READY_FOR_CLOSE),
        INTERVIEWERS_LOAD_FILLED_IN(Category.GROUP_READY_FOR_CLOSE),

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

        List<Academy> allAcademies = academyRepository.findAll();

        List<CheckListByGroupsDto> checkListByGroupsDtos = new ArrayList<>();

        for (Academy academy : allAcademies) {
            checkListByGroupsDtos.add(getCheckListByGroupDtoByAcademy(academy));
        }
        return checkListByGroupsDtos;
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
        for (Map.Entry<Key, CheckPredicate<Student>> predicate : studentsPredicates.entrySet()) {
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
        List<GroupInfoTeachers> experts = groupInfoTeachersRepository.findAllByAcademyIdAndTeacherTypeId(academyId,
                TEACHER_TYPE_EXPERT_ID);
        List<GroupInfoTeachers> interviewers = groupInfoTeachersRepository.findAllByAcademyIdAndTeacherTypeId(academyId,
                TEACHER_TYPE_INTERVIEWER_ID);
        Map<String, Integer> report = checkListByGroupsDto.getReport();
        checkListByGroupsDto.setTeachers(getTeachers(teachers));
        checkListByGroupsDto.setExperts(getTeachers(experts));

        for (Map.Entry<Key, CheckPredicate<GroupInfoTeachers>> predicate : teachersPredicates.entrySet()) {
            String key = predicate.getKey().toString();
            List<GroupInfoTeachers> list;
            if (key.toLowerCase().contains("teacher")) {
                list = teachers;
            } else if (key.toLowerCase().contains("expert")) {
                list = experts;
            } else {
                list = interviewers;
            }
            report.put(key, predicate.getValue().check(list));
        }
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

    private void setTotal(CheckListByGroupsDto checkListByGroupsDto) {
        double sum = 0;
        Map<String, Integer> report = checkListByGroupsDto.getReport();
        for (Map.Entry<String, Integer> s : report.entrySet()) {
            sum += s.getValue();
        }
        checkListByGroupsDto.setTotal((double) Math.round((sum / report.size()) * 100 * 100) / 100);

        int flag = TRUE;
        for (Category category : Category.values()) {
            if (flag == TRUE) {
                flag = checkCategory(category, report);
            }
            report.put(category.toString(), flag);
        }

    }

    private Integer checkCategory(Category category, Map<String, Integer> report) {
        Integer flag = TRUE;
        for (Key key : Key.getByCategory(category)) {
            flag *= report.get(key.toString());
        }
        return flag;
    }

    private static final Map<Key, CheckPredicate<Student>> studentsPredicates;
    private static final Map<Key, CheckPredicate<GroupInfoTeachers>> teachersPredicates;

    static {
        studentsPredicates = new HashMap<>();
        studentsPredicates.put(Key.ENGLISH_LEVEL_DEFINED, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getEnglishLevel() == null;
        });
        studentsPredicates.put(Key.ENGLISH_LEVEL_CORRECT, student -> {
            StudentTestData data = student.getData();
            if (data == null) {
                return false;
            }
            EnglishLevel englishLevel = data.getEnglishLevel();
            return englishLevel != null && englishLevel.getEnglishLevelId() < ENGLISH_LEVEL_PRE_INTERMEDIATE_ID;
        });
        studentsPredicates.put(Key.ENTRY_SCORE_DEFINED, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getEntryScore() == null;
        });
        studentsPredicates.put(Key.INCOMING_TEST_DEFINED, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getIncomingTest() == null;
        });
        studentsPredicates.put(Key.APPROVED_BY_DEFINED, student -> student.getApprovedBy() == null);
        studentsPredicates.put(Key.INTERMEDIATE_TEST_BASE_PASS, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getIntermBase() == null;
        });
        studentsPredicates.put(Key.INTERMEDIATE_TEST_LANG_PASS, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getIntermLang() == null;
        });
        studentsPredicates.put(Key.TEACHER_FEEDBACKS_FILLED_IN, student -> {
                StudentTestData data = student.getData();
                return data != null && student.getTeacherFeedback() == null && data.getTeacherScore() == null;
                });
        studentsPredicates.put(Key.EXPERT_FEEDBACKS_FILLED_IN, student -> {
                    StudentTestData data = student.getData();
                    return data != null && student.getExpertFeedback() == null && data.getExpertScore() == null;
                });
        studentsPredicates.put(Key.FINAL_TEST_BASE_PASS, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getFinalBase() == null;
        });
        studentsPredicates.put(Key.FINAL_TEST_LANG_PASS, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getFinalLang() == null;
        });
        studentsPredicates.put(Key.INTERVIEWER_SUMMARY_DEFINED, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getInterviewerComment() == null;
        });
        studentsPredicates.put(Key.TEST1, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getTestOne() == null;
        });
        studentsPredicates.put(Key.TEST2, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getTestTwo() == null;
        });
        studentsPredicates.put(Key.TEST3, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getTestThree() == null;
        });
        studentsPredicates.put(Key.TEST4, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getTestFour() == null;
        });
        studentsPredicates.put(Key.TEST5, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getTestFive() == null;
        });
        studentsPredicates.put(Key.TEST6, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getTestSix() == null;
        });
        studentsPredicates.put(Key.TEST7, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getTestSeven() == null;
        });
        studentsPredicates.put(Key.TEST8, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getTestEight() == null;
        });
        studentsPredicates.put(Key.TEST9, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getTestNine() == null;
        });
        studentsPredicates.put(Key.TEST10, student -> {
            StudentTestData data = student.getData();
            return data != null && data.getTestTen() == null;
        });

        teachersPredicates = new HashMap<>();
        teachersPredicates.put(Key.TEACHER_DEFINED, git -> false);
        teachersPredicates.put(Key.EXPERT_DEFINED, git -> false);
        teachersPredicates.put(Key.EXPERTS_LOAD_FILLED_IN, git -> git.getContributedHours() == null);
        teachersPredicates.put(Key.INTERVIEWER_DEFINED, git -> false);
        teachersPredicates.put(Key.INTERVIEWERS_LOAD_FILLED_IN, git -> git.getContributedHours() == null);
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
