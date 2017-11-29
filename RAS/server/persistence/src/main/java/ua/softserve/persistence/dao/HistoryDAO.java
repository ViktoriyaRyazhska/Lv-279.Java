package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.History;

import java.util.List;

public interface HistoryDAO extends JpaRepository<History, Integer> {

    List<History> findByAcademyName(String name);
    List<History> findAll();

}
