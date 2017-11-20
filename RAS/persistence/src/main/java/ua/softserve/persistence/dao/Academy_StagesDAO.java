package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Academy_Stages;

import java.util.List;

public interface Academy_StagesDAO extends JpaRepository<Academy_Stages, Integer> {

}
