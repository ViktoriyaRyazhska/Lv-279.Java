package ua.softserve.persistence.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.ItaAcademy;
import ua.softserve.persistence.entity.User;

import java.util.List;

@Repository
public interface ItaAcademyRepository extends JpaRepository<ItaAcademy, Integer> {

//
//    @Query("select it from ItaAcademy as it where it.academy.academyId = :academyId")
//    List<ItaAcademy> findItaAcademiesByAcademy(@Param("academyId") Integer academyId);

    List<ItaAcademy> findAllByAcademy_AcademyId( Integer academyId);

    @Query ("select it.user from ItaAcademy as it where it.itaAcademyStatus = 6 and it.academy.academyId = :academyId")
    List<User>  findAllUsersByAcademy(@Param("academyId") Integer academyId);



    ItaAcademy  findItaAcademyByAcademyAndUser(int academy_Id, int id);
}
