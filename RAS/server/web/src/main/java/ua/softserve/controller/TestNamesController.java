package ua.softserve.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.TestName;
import ua.softserve.service.TestNameService;

import java.util.List;

@RestController
public class TestNamesController {
    @Autowired
    TestNameService testNameService;

    private static final Logger logger = LogManager.getLogger(TestNamesController.class);

    @RequestMapping(value = "/tests/{id}", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<List<TestName>> showTestsNames(@PathVariable("id") Integer groupId) {
        return new ResponseEntity<List<TestName>>(testNameService.findAllTestNamesByAcademyId(groupId), HttpStatus.OK);
    }

    @RequestMapping(value = "/tests/add/{id}", method = RequestMethod.POST, produces = { "application/json" })
    public ResponseEntity<Integer> saveTestsNames(@PathVariable("id") int groupId,@RequestBody List<TestName> testNames) {

        if(testNameService.saveTestNames(testNames,groupId).equals("success")) {
            logger.info("test names successfully saved");
            return new ResponseEntity<Integer>(0, HttpStatus.OK);
        }
        else{
            logger.info("Bad request");
            return new ResponseEntity<Integer>(1,HttpStatus.BAD_REQUEST);
        }
    }
}
