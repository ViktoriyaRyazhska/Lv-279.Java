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

    @Transactional
    public void saveTestNames(List<TestName> testNames){
        for(TestName testName : testNames)
        testNameRepository.save(testName);
    }

    public List<TestName> findAllTestNames (){
        return testNameRepository.findAll();
    }

    @Override
    public List<TestName> findAllTestNamesByAcademyId(Integer groupId) {
        return  testNameRepository.findAllTestNamesBygroupId(groupId);
    }
}
