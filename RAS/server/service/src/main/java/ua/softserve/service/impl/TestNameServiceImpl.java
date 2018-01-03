package ua.softserve.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.TestName;
import ua.softserve.persistence.repo.TestNameRepository;
import ua.softserve.service.TestNameService;

import java.util.List;

@Service
public class TestNameServiceImpl implements TestNameService {
    @Autowired
    private TestNameRepository testNameRepository;

    @Autowired
    private AcademyServiceImpl academyService;

    private static final Logger logger = LogManager.getLogger(TestNameServiceImpl.class);

    @Override
    @Transactional
    public int saveTestNames(List<TestName> testNames, Integer academyId) {

        for (TestName testName : testNames) {
            if (testName.getTestName() == null || testName.getTestMaxScore() == null
                    || testName.getTestName().equals("")) {
                logger.info("Do not send us 'null'! Try again!");
                return TestNameService.DataIsWrong;
            }
            if (testName.getTestName().length() >= 50) {
                logger.info("Test name is incorrect");
                return TestNameService.DataIsWrong;
            }
            if (testName.isRemoved()){
                this.deleteTestName(testName);
            } else {
                testName.setGroupId(academyService.findOne(academyId));
                testNameRepository.save(testName);
            }
        }
        return TestNameService.DataIsOk;
    }

    @Override
    public List<TestName> findAllTestNames() {
        return testNameRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestName> findAllTestNamesByAcademyId(Integer groupId) {
        return testNameRepository.findAllTestNamesByGroupId(academyService.findOne(groupId));
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
