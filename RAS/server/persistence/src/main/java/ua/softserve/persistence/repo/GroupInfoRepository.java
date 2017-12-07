package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.softserve.persistence.entity.GroupInfo;

import java.util.List;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Integer> {
    List<GroupInfo> findAll();

    GroupInfo findByAcademyAcademyId(int academyId);
}
