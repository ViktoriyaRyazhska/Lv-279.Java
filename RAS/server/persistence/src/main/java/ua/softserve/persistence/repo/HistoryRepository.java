package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.History;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Integer> {

    List<History> findByAcademyId(int academyId);

    List<History> findAll();

}
