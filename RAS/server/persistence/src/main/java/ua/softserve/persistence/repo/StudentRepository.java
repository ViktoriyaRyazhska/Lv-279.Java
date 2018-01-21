package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Student;
import ua.softserve.persistence.entity.StudentStatuses;

import java.util.List;

import static ua.softserve.persistence.constants.ConstantsFromDb.*;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Integer countAllByAcademyAndStudentStatus(Academy academy, StudentStatuses studentStatus);

    Integer countAllByAcademyAcademyIdAndRemovedIsFalse(int academyId);

    Student findStudentByAcademyAcademyIdAndUserId(int academyId, int userId);

    List<Student> findAllByAcademyAcademyIdAndRemovedIsFalse (int academyId);
}
