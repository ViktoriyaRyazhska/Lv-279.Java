package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.ItaTacticalReport;

public interface ItaTacticalReportRepository extends JpaRepository<ItaTacticalReport, Integer> {

    @Override
    ItaTacticalReport findOne(Integer integer);

}
