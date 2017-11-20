package ua.softserve.service;


import ua.softserve.persistence.entity.ItaAcademy;

import java.util.List;

public interface ItaAcademyService {

    List<ItaAcademy> getAllByAcademy(int academyID);

    ItaAcademy  getItaAcademyById(int id);

    void updateItaAcademyUserStatus(int itaAcademyStatus, int academyId, int userId);
}
