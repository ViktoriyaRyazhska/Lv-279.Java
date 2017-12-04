package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.GroupInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Integer> {
    GroupInfo findByAcademyAcademyId(int academyId);
}
