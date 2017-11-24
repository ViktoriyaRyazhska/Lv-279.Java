package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Integer> {

    @Query("select st from Student as st where st.itaAcademy.academy.academyId = :academyId and st.itaAcademy.itaAcademyStatus = :status")
    List<Student> findStudentsByAcademyAndStatus(@Param("academyId") Integer academyId, @Param("status") Integer itaAcademyStatus);

    @Query("select st from Student as st where st.itaAcademy.academy.academyId = :academyId and st.itaAcademy.itaAcademyStatus <> :status order by st.itaAcademy.user.id")
    List<Student> findStudentsByAcademyAndStatusNot(@Param("academyId") Integer academyId, @Param("status") Integer itaAcademyStatus);

    @Query("select st from Student as st where st.itaAcademy.academy.academyId = :academyId and st.itaAcademy.user.id = :userId")
    Student findStudentByAcademyAndUser(@Param("academyId") Integer academyId, @Param("userId") Integer userId);

    @Modifying
    @Query(value = "update ita_academy set it_academy_status_id = :status where academy_id = :academyId and user_id in :userIds", nativeQuery = true)
    void updateItaStatus(@Param("status") Integer status, @Param("academyId") Integer academyId, @Param("userIds") List<Integer> userIds);

}
