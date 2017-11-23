package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.Student;

import java.util.List;

public interface StudentRepository  extends JpaRepository<Student,Integer> {

    @Query ("select st from Student as st where st.itaAcademy.academy.academyId = :academyId and st.itaAcademy.itaAcademyStatus = :status")
    List<Student>  findStudentsByAcademyAndStatus(@Param("academyId")Integer academyId,@Param("status")Integer itaAcademyStatus);

    List<Student> findAllByItaAcademy_Academy_AcademyIdAndItaAcademy_ItaAcademyStatus(Integer academyId,Integer itaAcademyStatus);

}
