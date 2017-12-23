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

import ua.softserve.persistence.dto.CheckListDto;

import java.util.List;

public interface CheckListReportService {

    List<CheckListDto> getCheckListDto();

}
