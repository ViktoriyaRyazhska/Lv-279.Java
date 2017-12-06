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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.LanguageTranslations;
import ua.softserve.service.CheckListByGroupsDtoService;
import ua.softserve.service.FeedbackService;
import ua.softserve.service.LanguageTranslationsService;
import ua.softserve.service.StudentService;
import ua.softserve.service.dto.CheckListByGroupsDto;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class FakeControllerForReports {

    @Autowired
    private LanguageTranslationsService languageTranslationsService;

    @Autowired
    private CheckListByGroupsDtoService checkListByGroupsDtoService;

    @GetMapping(value = "/check_list_by_groups{count}", produces = "application/json")
    public ResponseEntity<List<CheckListByGroupsDto>> getCheckListByGroupsDto(@PathVariable int count) {
        return new ResponseEntity<>(checkListByGroupsDtoService.fakeGetAllCheckListByGroupsDto(count), HttpStatus.OK);
    }

    @GetMapping(value = "/testLang", produces = "application/json")
    public ResponseEntity<LanguageTranslations> testLang() {
        return new ResponseEntity<>(languageTranslationsService.findOne(1), HttpStatus.OK);
    }

}
