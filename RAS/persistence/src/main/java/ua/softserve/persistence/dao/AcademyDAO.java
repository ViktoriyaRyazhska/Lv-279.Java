package ua.softserve.persistence.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.Academy;

@Repository
public interface AcademyDAO extends JpaRepository<Academy, Integer> {
}
