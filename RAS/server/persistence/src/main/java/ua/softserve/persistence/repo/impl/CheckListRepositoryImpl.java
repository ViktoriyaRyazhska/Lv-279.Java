/*
 * CustomRepository
 *
 * Version 1.0-SNAPSHOT
 *
 * 21.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.persistence.repo.impl;

import org.springframework.stereotype.Repository;
import ua.softserve.persistence.dto.CheckListDto;
import ua.softserve.persistence.repo.CheckListRepository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class CheckListRepositoryImpl implements CheckListRepository {

    @PersistenceContext
    private EntityManager entityManager;

    private static byte TRUE = 1;

    public CheckListDto reportCheckList(Integer academyId){
        StoredProcedureQuery reportCheckList = entityManager.createStoredProcedureQuery("reportCheckList");
        reportCheckList.registerStoredProcedureParameter("academy_id_in", Integer.class, ParameterMode.IN);
        reportCheckList.setParameter("academy_id_in", academyId);
        reportCheckList.execute();
        Object[] singleResult = (Object[]) reportCheckList.getSingleResult();
        int i = 0;
        CheckListDto checkListDto = new CheckListDto();
        Map<String, Object> report = new LinkedHashMap<>();
        for (Key key : Key.values())
            report.put(key.toString(), singleResult[i++]);
        checkListDto.setReport(report);
        setTotal(checkListDto);
        return checkListDto;
    }

    private void setTotal(CheckListDto checkListDto) {
        Map<String, Object> report = checkListDto.getReport();
        double sum = 0;
        for (Map.Entry<String, Object> s : report.entrySet()) {
            Object value = s.getValue();
            if (value instanceof Byte) {
                sum += (Byte) value;
            }
        }
        checkListDto.setTotal((double) Math.round((sum / report.size()) * 100 * 100) / 100);

        byte flag = TRUE;
        for (Category category : Category.values()) {
            if (category == Category.NO_CATEGORY) {
                continue;
            }
            if (flag == TRUE) {
                flag = checkCategory(category, report);
            }
            report.put(category.toString(), flag);
        }
    }

    private Byte checkCategory(Category category, Map<String, Object> report) {
        byte flag = TRUE;
        for (Key key : Key.getByCategory(category)) {
            flag *= (Byte) report.get(key.toString());
        }
        return flag;
    }

    private enum Key {
        groupName(Category.NO_CATEGORY),
        cityName(Category.NO_CATEGORY),
        status(Category.NO_CATEGORY),
        teachers(Category.NO_CATEGORY),
        experts(Category.NO_CATEGORY),
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

}
