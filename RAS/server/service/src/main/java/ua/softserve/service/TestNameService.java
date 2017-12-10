package ua.softserve.service;

import ua.softserve.persistence.entity.TestName;

import java.util.List;

public interface TestNameService {
    public void saveAl(TestName testName);
    List<TestName> findAllTestNames ();
}
