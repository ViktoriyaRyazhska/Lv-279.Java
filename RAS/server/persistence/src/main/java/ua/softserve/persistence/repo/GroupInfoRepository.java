package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.softserve.persistence.entity.GroupInfo;

import java.util.List;

/**
 * Interface contains methods that works with GroupInfo table.
 */
public interface GroupInfoRepository extends JpaRepository<GroupInfo, Integer> {
    /**
     * Method returns data from GroupInfo table in descending order.
     * 
     * @return data from GroupInfo table in descending order.
     */
    @Query("select gi from GroupInfo gi order by gi.groupInfoId desc")
    List<GroupInfo> findAllWithOrder();

    /**
     * Method returns data from GroupInfo table by id of the academy.
     * 
     * @param academyId
     *            id of the academy.
     * @return returns data from GroupInfo table.
     */
    GroupInfo findByAcademyAcademyId(int academyId);

}


