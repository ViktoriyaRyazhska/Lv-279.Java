package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.TestName;
import ua.softserve.service.GroupInfoService;

import java.util.ArrayList;
import java.util.List;


@RestController
public class TestNamesController {

    @Autowired
    GroupInfoService groupInfoService;

    @RequestMapping(value = "/tests/{id}", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity <List<TestName>> showTestsNames(@PathVariable("id") Integer groupId) {
//        TestName testName = new TestName("test1", 10);
//        testNameService.saveAl(testName);
//        List<TestName> testNames = groupInfoService.findAllTestNamesByAcademyId(groupId);

        return new ResponseEntity <List<TestName>> (groupInfoService.findAllTestNamesByAcademyId(groupId), HttpStatus.OK);
    }
    @RequestMapping(value = "/tests/add/{id}", method = RequestMethod.GET, produces = { "application/json" })
    public void saveTestsNames(@PathVariable("id") int groupId) {
        List<TestName> testNames = new ArrayList<>();
        testNames.add(new TestName(groupId,"myTestSaving",10));
        groupInfoService.saveTestNames(testNames,groupId);
    }
}
