package ua.softserve.service;

import ua.softserve.persistence.entity.TestNamesTemplate;

import java.util.List;

public interface TestNamesTemplateService {
    List<TestNamesTemplate> getTestTemplates();
    TestNamesTemplate getTestTemplateByDirectionId(Integer directionId);
}
