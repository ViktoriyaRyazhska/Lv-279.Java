package ua.softserve.persistence.repo;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.Academy;


@Repository
public interface AcademyRepository extends JpaRepository<Academy, Integer> {
//    @Query("from Academy t left outer join fetch t.experts where t.name=:name")
//    List<Academy> findAllByName(@Param("name")String name);
//
//    @Query("from Academy t left outer join fetch t.teachers where t.academyId=:id")
//    Academy findWithEmployeeTeacher(@Param("id")int id);
//
//    @Query("from Academy t left outer join fetch t.experts where t.academyId=:id")
//    Academy findWithEmployeeExperts(@Param("id")int id);
//
//    @Query("from Academy t left outer join fetch t.experts")
//    List<Academy> findWithEmployeeExperts();
//
//    @Query("from Academy t left outer join fetch t.interviewers where t.academyId=:id")
//    Academy findWithEmployeeInterviewers(@Param("id")int id);



}
