/*
 * FakeControllerForReports
 *
 * Version 1.0-SNAPSHOT
 *
 * 30.11.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.dto.CheckListDto;
import ua.softserve.persistence.entity.ItaTacticalReport;
import ua.softserve.service.CheckListByGroupsDtoService;
import ua.softserve.service.ItaTacticalReportService;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ControllerForReports {

    @Qualifier("checkListDtoServiceImpl")
    @Autowired
    private CheckListByGroupsDtoService checkListByGroupsDtoService;
    @Autowired
    ItaTacticalReportService itaTacticalReportService;

    @GetMapping("/check_list_by_groups")
    public ResponseEntity<List<CheckListDto>> getCheckListByGroupsDto() {
        return new ResponseEntity<>(checkListByGroupsDtoService.getCheckListDto(), HttpStatus.OK);
    }


    @GetMapping(value = "/ita_tactical_report")
    public ResponseEntity<List<List<ItaTacticalReport>>> getItaTacticalrReport() {
        return new ResponseEntity<>(itaTacticalReportService.generateItaTacticalReport(), HttpStatus.OK);
    }


}
