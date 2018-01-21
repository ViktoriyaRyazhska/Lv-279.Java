package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.GroupInfo;

import java.util.List;

/**
 * Interface contains methods that works with GroupInfo table.
 */
public interface GroupInfoRepository extends JpaRepository<GroupInfo, Integer> {
    /**
     * Method returns data from GroupInfo table by id of the academy.
     *
     * @param academyId id of the academy.
     * @return returns data from GroupInfo table.
     */
    GroupInfo findByAcademyAcademyId(int academyId);

    @Query(value = "select * from group_info as gi left join academy as a on gi.academy_id = a.academy_id",
            nativeQuery = true)
    List<GroupInfo> findAllGroupsWithAcademies();
}
