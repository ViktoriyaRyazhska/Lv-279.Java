package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Employee;

public interface AcademyRepository extends JpaRepository<Academy,Integer>{
}
