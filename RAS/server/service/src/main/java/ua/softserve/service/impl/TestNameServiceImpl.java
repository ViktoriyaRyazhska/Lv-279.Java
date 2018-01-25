package ua.softserve.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.TestName;
import ua.softserve.persistence.entity.TestNamesTemplate;
import ua.softserve.persistence.repo.TechnologiesRepository;
import ua.softserve.persistence.repo.TestNameRepository;
import ua.softserve.service.TestNameService;
import ua.softserve.service.TestNamesTemplateService;
import ua.softserve.service.exception.InvalidDataException;

import java.util.ArrayList;
import java.util.List;

/**
 * Service processes information that returns Repositories.
 */

@Service
public class TestNameServiceImpl implements TestNameService {
    @Autowired
    private TestNameRepository testNameRepository;

    @Autowired
    private AcademyServiceImpl academyService;

    @Autowired
    private TestNamesTemplateService testNamesTemplateService;

    @Autowired
    private TechnologiesRepository technologiesRepository;

    private static final Logger logger = LogManager.getLogger(TestNameServiceImpl.class);


    /**
     * Method remove data with appropriate flag or save data to db.
     *
     * @param testNames that comes from client
     * @param academyId
     * @return boolean
     */
    @Override
    @Transactional
    public boolean saveTestNames(List<TestName> testNames, Integer academyId) {
        try {
            testNames.stream()
                    .filter(this::isValidTestNames)
                    .forEach(testName -> {
                        if (testName.isRemoved()) {
                            this.deleteTestName(testName);
                        }
                        else {
                            testName.setGroupId(academyService.findOne(academyId));
                            testNameRepository.save(testName);
                        }
                    });
        }catch (RuntimeException e) {
            logger.catching(e);
            return false;
        }
        return true;
    }

    public boolean isValidTestNames(TestName testName) {
        if (testName.getTestName() == null || testName.getTestMaxScore() == null
                || testName.getTestName().equals("")) {
             throw new InvalidDataException("Do not send us 'null'! Try again!");
        }
        if (testName.getTestName().length() >= 50) {
            throw new InvalidDataException("Test name is incorrect");
        }
        if(testName.getTestSequenceNum() > 10 || testName.getTestSequenceNum() <=0 || testName.getTestSequenceNum() == null){
            throw new InvalidDataException("Test sequence number incorrect");
        }
        else
            return true;
    }

    @Override
    public List<TestName> findAllTestNames() {
        return testNameRepository.findAll();
    }

    /**
     * Method get all tests templates for special direction and push it to testName.
     *
     * @param groupId that comes from client
     * @param directionId that comes from client
     * @return List<TestName>
     */
    @Override
    @Transactional(readOnly = true)
    public List<TestName> findAllTestNamesByAcademyId(Integer groupId, Integer directionId) {
        Academy academy = academyService.findOne(groupId);
        if (testNameRepository.findAllTestNamesByGroupId(academy).isEmpty()){
            List<TestNamesTemplate> testNamesTemplates = testNamesTemplateService.getAllByDirectionId(directionId);
            List<TestName> testNames = new ArrayList<>();
            for (TestNamesTemplate testNamesTemplate : testNamesTemplates){
                testNames.add(new TestName(academy,testNamesTemplate.getTestName(),testNamesTemplate.getTestMaxScore()));
            }
            return testNames;
        }
        else {
            return testNameRepository.findAllTestNamesByGroupId(academy);
        }
    }

    @Override
    @Transactional
    public void deleteTestName(TestName testName) {
        testNameRepository.delete(testName);
    }

    @Override
    public boolean isTestRemoved(TestName test) {
        return test.isRemoved();
    }
}
