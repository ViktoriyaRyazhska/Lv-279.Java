package ua.softserve.service;

import ua.softserve.persistence.entity.TestName;

import java.util.List;

public interface TestNameService {
    public static final int DataIsWrong = 400;
    public static final int DataIsOk = 200;

    boolean saveTestNames(List<TestName> testNames, Integer academyId);

    List<TestName> findAllTestNames();

    List<TestName> findAllTestNamesByAcademyId(Integer groupId);

    void deleteTestName(TestName testName);

    boolean isTestRemoved(TestName test);
}
