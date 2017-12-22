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
import ua.softserve.persistence.repo.CheckListRepository;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.service.CheckListByGroupsDtoService;
import ua.softserve.service.ItaTacticalPlanByGroupStageDtoService;
import ua.softserve.service.dto.ItaTacticalPlanByGroupStageDto;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ControllerForReports {

    @Qualifier("checkListDtoServiceImpl")
    @Autowired
    private CheckListByGroupsDtoService checkListByGroupsDtoService;
    @Autowired
    ItaTacticalPlanByGroupStageDtoService itaTacticalPlanByGroupStageDtoService;

    @GetMapping("/check_list_by_groups")
    public ResponseEntity<List<CheckListDto>> getCheckListByGroupsDto() {
        return new ResponseEntity<>(checkListByGroupsDtoService.getCheckListDto(), HttpStatus.OK);
    }

//    @GetMapping(value = "/check_list_by_groups", produces = "application/json")
//    public ResponseEntity<List<CheckListByGroupsDto>> getCheckListByGroupsDto() {
//        return new ResponseEntity<>(checkListByGroupsDtoService.getAllCheckListByGroupsDto(), HttpStatus.OK);
//    }

    @RequestMapping(value = "/itaTacticalPlanByGroupStage", method = RequestMethod.GET, produces = {
            "application/json" })
    public ResponseEntity<List<List<ItaTacticalPlanByGroupStageDto>>> itaTacticalPlanByGroupStage() {
        return new ResponseEntity<>(itaTacticalPlanByGroupStageDtoService.itaTacticalPlanByGroupStageReport(),
                HttpStatus.OK);
    }

    /*@GetMapping(value = "/test/{id}")
    public ResponseEntity<CheckListDto> reportCheckList(@PathVariable Integer id) {
        return new ResponseEntity<>(checkListRepository.reportCheckList(id),
                HttpStatus.OK);
    }*/

}
