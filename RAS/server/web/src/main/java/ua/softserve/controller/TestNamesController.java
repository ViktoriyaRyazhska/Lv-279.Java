package ua.softserve.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.TestName;
import ua.softserve.persistence.entity.TestNamesTemplate;
import ua.softserve.service.TestNameService;
import ua.softserve.service.TestNamesTemplateService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class TestNamesController {
    @Autowired
    private TestNameService testNameService;

    @Autowired
    private TestNamesTemplateService testNamesTemplateService;

    private static final Logger logger = LogManager.getLogger(TestNamesController.class);

    @GetMapping(value = "/tests/{id}/{directionId}")
    public ResponseEntity showTestsNames(@PathVariable("id") Integer groupId, @PathVariable("directionId") Integer directionId) {
        try{
            return new ResponseEntity<List<TestName>>(testNameService.findAllTestNamesByAcademyId(groupId, directionId), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            logger.catching(e);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Group with id " + groupId + " not found");
        }
    }

    @PostMapping(value = "/tests/add/{id}")
    public ResponseEntity saveTestsNames(@PathVariable("id") int groupId,@RequestBody List<TestName> testNames) {

        if(testNameService.saveTestNames(testNames,groupId)) {
            logger.info("test names successfully saved");
            return new ResponseEntity(HttpStatus.CREATED);
        }
        else{
            logger.info("Bad request");
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/tests/template/{directionId}")
    public ResponseEntity getTestsTemplate(@PathVariable("directionId") Integer directionId) {
        try{
            return new ResponseEntity<List<TestNamesTemplate>>(testNamesTemplateService.getAllByDirectionId(directionId), HttpStatus.OK);
        }
        catch (NoSuchElementException e) {
            logger.catching(e);
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("template with id " + directionId + " not found");
        }
    }
}
