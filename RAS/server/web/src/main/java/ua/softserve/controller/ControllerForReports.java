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
import ua.softserve.service.CheckListByGroupsDtoService;
import ua.softserve.service.ItaTacticalPlanByGroupStageDtoService;
import ua.softserve.service.dto.CheckListByGroupsDto;
import ua.softserve.service.dto.ItaTacticalPlanByGroupStageDto;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ControllerForReports {

    @Autowired
    private CheckListByGroupsDtoService checkListByGroupsDtoService;
    @Autowired
    ItaTacticalPlanByGroupStageDtoService itaTacticalPlanByGroupStageDtoService;

    @GetMapping(value = "/check_list_by_groups", produces = "application/json")
    @CrossOrigin(origins = "${client_cross_origin}")
    public ResponseEntity<List<CheckListByGroupsDto>> getCheckListByGroupsDto() {
        return new ResponseEntity<>(checkListByGroupsDtoService.getAllCheckListByGroupsDto(), HttpStatus.OK);
    }


    @RequestMapping(value = "/itaTacticalPlanByGroupStage",method = RequestMethod.GET, produces = {"application/json"})
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<ItaTacticalPlanByGroupStageDto>> itaTacticalPlanByGroupStage() {
        return new ResponseEntity<>(itaTacticalPlanByGroupStageDtoService.findPlanedGroupForTwoMoth(), HttpStatus.OK);
    }

}
