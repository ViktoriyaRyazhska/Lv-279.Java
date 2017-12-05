package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.GroupInfo;

import java.util.List;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Integer>{
    GroupInfo findByAcademyAcademyId(int academyId);
}
