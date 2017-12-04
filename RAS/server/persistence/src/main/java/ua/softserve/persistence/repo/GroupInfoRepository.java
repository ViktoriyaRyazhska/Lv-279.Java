package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.GroupInfo;

public interface GroupInfoRepository extends JpaRepository<GroupInfo, Integer>{
}
