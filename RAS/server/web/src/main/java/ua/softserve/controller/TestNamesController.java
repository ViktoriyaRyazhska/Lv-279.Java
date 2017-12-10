package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.TestName;
import ua.softserve.service.GroupInfoService;

import java.util.List;


@RestController
public class TestNamesController {

    @Autowired
    GroupInfoService groupInfoService;

    @RequestMapping(value = "/tests/{id}", method = RequestMethod.GET, produces = { "application/json" })
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<TestName> getTestsNames(@PathVariable("id") Integer groupId) {
//        TestName testName = new TestName("test1", 10);
//        testNameService.saveAl(testName);
        List<TestName> testNames = groupInfoService.findAllTestNamesByAcademyId(groupId);
        return new ResponseEntity <TestName> (testNames.get(0), HttpStatus.OK);
    }
}
