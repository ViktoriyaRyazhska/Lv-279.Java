package ua.softserve.persistence.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.Academy;

import java.util.List;


@Repository
public interface AcademyDAO extends JpaRepository<Academy, Integer> {
    List<Academy> findAllByName(String name);

    @Query("from Academy t left outer join fetch t.teachers where t.academyId=:id")
    Academy findWithEmployeeTeacher(@Param("id")int id);

    @Query("from Academy t left outer join fetch t.experts where t.academyId=:id")
    Academy findWithEmployeeExperts(@Param("id")int id);

    @Query("from Academy t left outer join fetch t.interviewers where t.academyId=:id")
    Academy findWithEmployeeInterviewers(@Param("id")int id);
}
