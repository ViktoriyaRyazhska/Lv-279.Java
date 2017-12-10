package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.entity.TestName;

import java.util.List;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Integer> {
    List<GroupInfo> findAll();

    GroupInfo findByAcademyAcademyId(int academyId);

    @Query("select testNames from GroupInfo gi where gi.academy.academyId = :academyId")
    List<TestName> findTestNamesByAcademyId (@Param("academyId") Integer academyId);
}
