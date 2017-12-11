package ua.softserve.service;

import ua.softserve.persistence.entity.TestName;

import java.util.List;

public interface TestNameService {
    void saveTestNames(List<TestName> testName);
    List<TestName> findAllTestNames ();
    List<TestName> findAllTestNamesByAcademyId(Integer groupId);
}
