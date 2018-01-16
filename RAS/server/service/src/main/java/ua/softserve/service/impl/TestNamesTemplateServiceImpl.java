package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.TestNamesTemplate;
import ua.softserve.persistence.repo.TechnologiesRepository;
import ua.softserve.persistence.repo.TestNamesTemplateRepository;
import ua.softserve.service.TestNamesTemplateService;

import java.util.List;

@Service
public class TestNamesTemplateServiceImpl implements TestNamesTemplateService {
    @Autowired
    private TestNamesTemplateRepository testNamesTemplateRepository;

    @Autowired
    private TechnologiesRepository technologiesRepository;

    @Override
    public List<TestNamesTemplate> getTestTemplates() {
        return testNamesTemplateRepository.findAll();
    }

    @Override
    public TestNamesTemplate getTestTemplateByDirectionId(Integer directionId) {
        return testNamesTemplateRepository.findByTestTemplateId(directionId);
    }

    @Override
    public List<TestNamesTemplate> getAllByDirectionId(Integer directionId) {
        return testNamesTemplateRepository.findAllByTechnologies(technologiesRepository.findOne(directionId));
    }
}
