package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.ItaTacticalReport;

import java.util.List;

public interface ItaTacticalReportRepository extends JpaRepository<ItaTacticalReport, Integer> {

    List<ItaTacticalReport> findAllByAcademyIdIn(List<Integer> ids);

}
