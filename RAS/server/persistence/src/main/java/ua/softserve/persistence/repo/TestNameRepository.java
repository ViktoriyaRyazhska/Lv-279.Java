package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.TestName;


@Repository
public interface TestNameRepository extends JpaRepository<TestName, Integer> {

}
