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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.dto.CheckListDto;
import ua.softserve.persistence.entity.ItaTacticalReport;
import ua.softserve.service.ItaTacticalReportService;
import ua.softserve.service.CheckListReportService;


import java.util.List;

@RestController
@RequestMapping("/reports")
public class ControllerForReports {

    @Autowired
    private CheckListReportService checkListReportService;
    @Autowired
    ItaTacticalReportService itaTacticalReportService;

    @GetMapping("/check_list_by_groups")
    public ResponseEntity<List<CheckListDto>> getCheckListByGroupsDto() {
        return new ResponseEntity<>(checkListReportService.getCheckListDto(), HttpStatus.OK);
    }


    @GetMapping(value = "/ita_tactical_report")
    public ResponseEntity<List<List<ItaTacticalReport>>> getItaTacticalrReport() {
        return new ResponseEntity<>(itaTacticalReportService.generateItaTacticalReport(), HttpStatus.OK);
    }


}
