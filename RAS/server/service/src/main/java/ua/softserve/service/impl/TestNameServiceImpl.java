package ua.softserve.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.TestName;
import ua.softserve.persistence.entity.TestNamesTemplate;
import ua.softserve.persistence.repo.TechnologiesRepository;
import ua.softserve.persistence.repo.TestNameRepository;
import ua.softserve.service.TestNameService;
import ua.softserve.service.TestNamesTemplateService;
import ua.softserve.service.exception.InvalidDataException;

import java.util.ArrayList;
import java.util.List;

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
        } else
            return true;
    }

    @Override
    public List<TestName> findAllTestNames() {
        return testNameRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestName> findAllTestNamesByAcademyId(Integer groupId, Integer directionId) {
        if (testNameRepository.findAllTestNamesByGroupId(academyService.findOne(groupId)).isEmpty()){
            List<TestNamesTemplate> testNamesTemplates = testNamesTemplateService.getAllByDirectionId(directionId);
            List<TestName> testNames = new ArrayList<>();
            for (TestNamesTemplate testNamesTemplate : testNamesTemplates){
                testNames.add(new TestName(academyService.findOne(groupId),testNamesTemplate.getTestName(),testNamesTemplate.getTestMaxScore()));
            }
            return testNames;
        }
        else {
            return testNameRepository.findAllTestNamesByGroupId(academyService.findOne(groupId));
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
