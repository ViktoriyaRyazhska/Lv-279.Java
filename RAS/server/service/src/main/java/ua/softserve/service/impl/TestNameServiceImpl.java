package ua.softserve.service.impl;

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

    @Override
    @Transactional
    public void saveTestNames(List<TestName> testNames, Integer academyId) {

        for (TestName testName : testNames) {
            if (testName.getTestMaxScore() == 0) {
                this.deleteTestName(testName);
            } else {
                testName.setGroupId(academyId);
                testNameRepository.save(testName);
            }
        }
    }

    @Override
    public List<TestName> findAllTestNames() {
        return testNameRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<TestName> findAllTestNamesByAcademyId(Integer groupId) {
        return testNameRepository.findAllTestNamesBygroupId(groupId);
    }

    @Override
    @Transactional
    public void deleteTestName(TestName testName) {
        testNameRepository.delete(testName);
    }
}
