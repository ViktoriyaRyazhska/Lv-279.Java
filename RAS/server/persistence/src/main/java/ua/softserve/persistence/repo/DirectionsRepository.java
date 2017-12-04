package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.softserve.persistence.entity.Directions;

import java.util.List;

public interface DirectionsRepository extends JpaRepository<Directions, Integer> {
    @Query("select d.name from Directions d")
    List<String> findDirectionsName();

    @Query("select dr from Directions dr where ita = 1")
    List<Directions> findAllDirectionsInIta();
}
