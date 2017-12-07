package ua.softserve.persistence.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.StudentStatuses;
import ua.softserve.persistence.entity.Students;
import java.util.List;

@Repository
public interface StudentsRepository extends JpaRepository<Students, Integer> {
    Integer countAllByAcademyAndStudentStatus(Academy academy, StudentStatuses studentStatus);

    List<Students> findAllByStudentStatus(StudentStatuses studentStatus);
}
