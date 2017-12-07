package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Students;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {

    List<Students> findAllByAcademy_AcademyId(int academyId);

}
