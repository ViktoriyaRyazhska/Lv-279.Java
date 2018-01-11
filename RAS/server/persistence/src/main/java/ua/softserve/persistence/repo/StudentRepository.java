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

    Integer countAllByAcademy_AcademyIdAndRemovedIsFalse(int academyId);

    Student findStudentByAcademy_AcademyIdAndUser_Id(int academyId, int userId);

    List<Student> findAllByAcademy_AcademyIdAndRemovedIsFalse (int academyId);

    @Modifying
    @Query("update Student s set s.removed = :removed where s.id = :studentId")
    void updateRemovedStatus(@Param("studentId") Integer studentId,@Param("removed") boolean removed);

    @Modifying
    @Query("update Student s set s.data.interviewerComment = :comment where s.id = :studentId")
    void updateInterviewerComment(@Param("comment") String comment, @Param("studentId") Integer studentId);
}
