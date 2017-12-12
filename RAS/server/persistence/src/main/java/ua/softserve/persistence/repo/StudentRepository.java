package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Student;
import ua.softserve.persistence.entity.StudentStatuses;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findAllByAcademy_AcademyId(int academyId);

    List<Student> findAllByStudentStatus(StudentStatuses studentStatus);

    @Query("from Student s where s.academy.academyId =:academyId and s.removed = false")
    List<Student> findAllByAcademyId(@Param("academyId") Integer academyId);

    Integer countAllByAcademyAndStudentStatus(Academy academy, StudentStatuses studentStatus);

    @Query("from Student s where s.academy.academyId =:academyId and s.user.id =:id")
    Student ifStudentExist(@Param("academyId") Integer academyId, @Param("id") Integer id);

}
