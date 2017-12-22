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
import ua.softserve.service.CheckListReportService;
import ua.softserve.service.ItaTacticalPlanByGroupStageDtoService;
import ua.softserve.service.dto.ItaTacticalPlanByGroupStageDto;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ControllerForReports {

    @Autowired
    private CheckListReportService checkListReportService;
    @Autowired
    ItaTacticalPlanByGroupStageDtoService itaTacticalPlanByGroupStageDtoService;

    @GetMapping("/check_list_by_groups")
    public ResponseEntity<List<CheckListDto>> getCheckListByGroupsDto() {
        return new ResponseEntity<>(checkListReportService.getCheckListDto(), HttpStatus.OK);
    }

    @GetMapping(value = "/ita_tactical_plan_by_group_stage")
    public ResponseEntity<List<List<ItaTacticalPlanByGroupStageDto>>> itaTacticalPlanByGroupStage() {
        return new ResponseEntity<>(itaTacticalPlanByGroupStageDtoService.itaTacticalPlanByGroupStageReport(),
                HttpStatus.OK);
    }

}
