package ua.softserve.persistence.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.StudentStatuses;
import ua.softserve.persistence.entity.Students;


@Repository
public interface StudentsStatusesRepository extends JpaRepository<StudentStatuses, Integer> {

}
