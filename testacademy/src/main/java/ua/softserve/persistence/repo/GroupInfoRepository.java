package ua.softserve.persistence.repo;

import ua.softserve.persistence.entity.GroupInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Integer> {
    GroupInfo findByAcademyAcademyId(int academyId);
}
