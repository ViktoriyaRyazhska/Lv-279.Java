package ua.softserve.persistence.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.ItaAcademy;

import java.util.List;

@Repository
public interface ItaAcademyDao extends JpaRepository<ItaAcademy,Integer> {


    List<ItaAcademy> findItaAcademiesByAcademy(int academy_Id);


    ItaAcademy  findItaAcademyByAcademyAndUser(int academy_Id, int id);
}
