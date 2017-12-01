package ua.softserve.persistence.repo;

import ua.softserve.persistence.entity.GroupInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroupRepo extends JpaRepository<GroupInfo, Integer> {
    GroupInfo findByAcademy_AcademyId(int id);
}
