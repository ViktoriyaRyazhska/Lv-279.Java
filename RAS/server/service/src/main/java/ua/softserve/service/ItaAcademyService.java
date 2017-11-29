package ua.softserve.service;


import ua.softserve.persistence.entity.ItaAcademy;
import ua.softserve.persistence.entity.User;

import java.util.List;

public interface ItaAcademyService {

    List<ItaAcademy> getAllItaAcademyByAcademy(Integer academyId);

    ItaAcademy  getItaAcademyById(Integer id);

    List<User> getAllUsersOfAcademy(Integer academyId);

    void addUserInAcademy(Integer academyId, Integer userId);

    void deleteUserInAcademy(Integer academyId, Integer userId);


}
