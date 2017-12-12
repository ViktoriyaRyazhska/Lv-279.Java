package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.TestName;

import java.util.List;

public interface TestNameRepository extends JpaRepository<TestName, Integer> {
    List<TestName> findAllTestNamesBygroupId(Integer academyId);
}
