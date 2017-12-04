package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.softserve.persistence.entity.Technologies;

import java.util.List;

public interface TechnologiesRepository extends JpaRepository<Technologies, Integer> {

    @Query("select th from Technologies th where ita = 1")
    List<Technologies> findAllTechonologyInIta();
}
