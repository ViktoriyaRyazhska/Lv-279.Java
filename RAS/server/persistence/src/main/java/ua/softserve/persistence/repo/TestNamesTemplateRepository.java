package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.TestNamesTemplate;

/**
 * Created by yaoun on 10.01.2018.
 */
@Repository
public interface TestNamesTemplateRepository extends JpaRepository<TestNamesTemplate, Integer> {
}
