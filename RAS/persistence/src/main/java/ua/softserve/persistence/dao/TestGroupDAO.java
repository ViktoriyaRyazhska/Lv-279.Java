package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.TestGroup;

import java.util.Collection;
import java.util.List;

public interface TestGroupDAO extends JpaRepository<TestGroup,Integer> {
    @Query("from TestGroup t left outer join fetch t.teachers where t.testgroup_id=:id")
    TestGroup findWithEmployeeTeacher(@Param("id")int id);

    @Query("from TestGroup t left outer join fetch t.experts where t.testgroup_id=:id")
    TestGroup findWithEmployeeExperts(@Param("id")int id);

    @Query("from TestGroup t left outer join fetch t.interviewers where t.testgroup_id=:id")
    TestGroup findWithEmployeeInterviewers(@Param("id")int id);
}
