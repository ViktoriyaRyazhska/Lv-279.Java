package ua.softserve.service;

import ua.softserve.persistence.entity.TestName;

import java.util.List;

public interface TestNameService {
    public static final String NullValue = "Do not send us 'null'! Try again!";
    public static final String DataIsWrong = "Do not send us incorrect values! please, do not try again.";
    public static final String DataIsGood = "success";
    String saveTestNames(List<TestName> testNames, Integer academyId);
    List<TestName> findAllTestNames ();
    List<TestName> findAllTestNamesByAcademyId(Integer groupId);
    void deleteTestName(TestName testName);
}
