package ua.softserve.persistence.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Employee;

import java.awt.print.Pageable;
import java.util.List;


@Repository
public interface AcademyDAO extends JpaRepository<Academy, Integer> {
    @Query("from Academy t left outer join fetch t.experts where t.name=:name")
    List<Academy> findAllByName(@Param("name")String name);

    @Query("from Academy t left outer join fetch t.teachers where t.academyId=:id")
    Academy findWithEmployeeTeacher(@Param("id")int id);

    @Query("from Academy t left outer join fetch t.experts where t.academyId=:id")
    Academy findWithEmployeeExperts(@Param("id")int id);

    @Query("from Academy t left outer join fetch t.experts")
    List<Academy> findWithEmployeeExperts();

    @Query("from Academy t left outer join fetch t.interviewers where t.academyId=:id")
    Academy findWithEmployeeInterviewers(@Param("id")int id);


}
