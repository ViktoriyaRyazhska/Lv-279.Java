/*
* CheckListByGroupsDtoService
*
* Version 1.0-SNAPSHOT
*
* 03.12.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.service;

import ua.softserve.persistence.entity.views.CheckListReport;

import java.util.List;

/**
 * Check List By Groups Report Service.
 */
public interface CheckListReportService {

    /**
     * Generate Check List By Groups Report.
     * @return list of Check List By Groups DTOs
     */
    List<CheckListReport> getCheckListDto();

}
