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
import ua.softserve.persistence.constants.CheckListReportCategory;
import ua.softserve.persistence.constants.CheckListReportValue;
import ua.softserve.persistence.dto.CheckListDto;
import ua.softserve.persistence.repo.CheckListRepository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import static ua.softserve.persistence.constants.ConstantsFromDb.FALSE;
import static ua.softserve.persistence.constants.ConstantsFromDb.TRUE;

/**
 * Implementation of Check List By Groups Report Repository.
 */
@Repository
public class CheckListRepositoryImpl implements CheckListRepository {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Returns Check List By Groups DTO by academy.
     * This method calls stored procedure and put result to Check List By Groups DTO.
     * @param academyId ID of academy.
     * @return Check List By Groups DTO.
     */
    public CheckListDto reportCheckList(Integer academyId){
        StoredProcedureQuery reportCheckList = entityManager.createStoredProcedureQuery("reportCheckList");
        reportCheckList.registerStoredProcedureParameter("academy_id_in", Integer.class, ParameterMode.IN);
        reportCheckList.setParameter("academy_id_in", academyId);
        reportCheckList.execute();
        Object[] singleResult = (Object[]) reportCheckList.getSingleResult();
        int i = 0;
        CheckListDto checkListDto = new CheckListDto();
        Map<String, Object> report = new LinkedHashMap<>();
        for (CheckListReportValue checkListReportValue : CheckListReportValue.values()) {
            Object reportValue = singleResult[i++];
            if (reportValue == null && i > 4) {
                reportValue = (byte) 0;
            }
            report.put(checkListReportValue.toString(), reportValue);
        }
        checkListDto.setReport(report);
        setTotal(checkListDto);
        return checkListDto;
    }

    /**
     * Calculate summary values of Check List By Groups DTO.
     * @param checkListDto Check List By Groups DTO.
     */
    private void setTotal(CheckListDto checkListDto) {
        Map<String, Object> report = checkListDto.getReport();
        double sum = 0;
        int countOfReportValues = 0;
        for (Map.Entry<String, Object> s : report.entrySet()) {
            Object value = s.getValue();
            if (value instanceof Byte) {
                sum += (Byte) value;
                countOfReportValues++;
            }
        }
        checkListDto.setTotal((double) Math.round((sum / countOfReportValues) * 100 * 100) / 100);

        boolean flag = true;

        for (CheckListReportCategory category : CheckListReportCategory.values()) {
            if (category == CheckListReportCategory.NO_CATEGORY) {
                continue;
            }
            if (flag) {
                flag = checkCategory(category, report);
            }
            report.put(category.toString(), flag ? TRUE : FALSE);
        }
    }

    /**
     * Check summary values of Check List By Groups DTO by particular category.
     * @param category particular category.
     * @param report values of report.
     * @return returns true only when all values are 'TRUE'.
     */
    private boolean checkCategory(CheckListReportCategory category, Map<String, Object> report) {
        return CheckListReportValue.getByCategory(category)
                .stream()
                .allMatch(value -> (Byte) report.get(value.toString()) == TRUE);
    }

}
