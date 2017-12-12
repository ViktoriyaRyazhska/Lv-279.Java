package ua.softserve.controller;

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

    @RequestMapping(value = "/tests/{id}", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity <List<TestName>> showTestsNames(@PathVariable("id") Integer groupId) {
        return new ResponseEntity <List<TestName>> (testNameService.findAllTestNamesByAcademyId(groupId), HttpStatus.OK);
    }
    @RequestMapping(value = "/tests/add/{id}", method = RequestMethod.POST, produces = { "application/json" })
    public void saveTestsNames(@PathVariable("id") int groupId,@RequestBody List<TestName> testNames) {
        for (TestName testName : testNames) {
            testName.setGroupId(groupId);
        }
        testNameService.saveTestNames(testNames);
    }
}
