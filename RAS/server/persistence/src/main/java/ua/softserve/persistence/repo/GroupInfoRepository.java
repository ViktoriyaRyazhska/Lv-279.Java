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
     * Method returns data from GroupInfo table in descending order.
     *
     * @return data from GroupInfo table in descending order.
     */
    @Query("select gi from GroupInfo gi order by gi.groupInfoId desc")
    List<GroupInfo> findAllWithOrder();

    /**
     * Method returns data from GroupInfo table by id of the academy.
     *
     * @param academyId id of the academy.
     * @return returns data from GroupInfo table.
     */
    GroupInfo findByAcademyAcademyId(int academyId);

//    @Query("select new ua.softserve.persistence.dto.GroupInformationDTO(ac.academyId, gi.groupName, gi.studentsPlannedToGraduate, gi.studentsPlannedToEnrollment, ac.startDate, ac.endDate, ac.free, ac.name, pi.profileName, tc.name, acS.name, " +
//            "(select count(stn.academy) from Student as stn where stn.academy = ac.academyId and stn.studentStatus = 1), empl, techT.teachertypeId " +
//            ") " +
//            "from GroupInfo as gi, GroupInfoTeachers giT " +
//            "left join gi.academy as ac " +
//            "left join gi.profileInfo as pi " +
//            "left join pi.technologies as tc " +
//            "left join ac.academyStages as acS " +
//            "left join giT.employee as empl " +
//            "left join giT.teacherType as techT " +
//            "join giT.academy as acam " +
//            "where acam.academyId = ac.academyId and (techT.teachertypeId = 2 or techT.teachertypeId = null) " +
//            "order by gi.groupInfoId desc, techT.teachertypeId asc")
//    List<GroupInformationDTO> findAllInfoAboutGroups();
//
//    @Query("select new ua.softserve.persistence.dto.GroupInformationDTO(acam.academyId, empl, techT.teachertypeId " +
//            ") " +
//            "from GroupInfo as gi, GroupInfoTeachers giT " +
//            "left join gi.academy as ac " +
//            "left join gi.profileInfo as pi " +
//            "left join pi.technologies as tc " +
//            "left join ac.academyStages as acS " +
//            "left join giT.employee as empl " +
//            "left join giT.teacherType as techT " +
//            "join giT.academy as acam " +
//            "where techT.teachertypeId = 2 or techT.teachertypeId is NULL " +
//            "order by acam.academyId desc, techT.teachertypeId asc")
//    List<GroupInformationDTO> findAllInfoAboutGroups1();
}
