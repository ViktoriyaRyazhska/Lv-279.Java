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

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.service.dto.CheckListByGroupsDto;

@RestController
@RequestMapping("/reports")
public class FakeControllerForReports {

    @GetMapping(value = "/check_list_by_groups", produces = "application/json")
    public ResponseEntity<CheckListByGroupsDto> getCheckListByGroupsDto() {

        CheckListByGroupsDto checkListByGroupsDto = new CheckListByGroupsDto();

        return new ResponseEntity<CheckListByGroupsDto>(checkListByGroupsDto, HttpStatus.OK);
    }


}
