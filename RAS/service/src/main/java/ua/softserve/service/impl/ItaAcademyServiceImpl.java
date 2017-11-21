package ua.softserve.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.dao.ItaAcademyDao;
import ua.softserve.persistence.entity.ItaAcademy;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.ItaAcademyService;

import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItaAcademyServiceImpl implements ItaAcademyService {

    @Autowired
    private ItaAcademyDao itaAcademyDao;

    @Transactional(readOnly = true)
    public List<ItaAcademy> getAllItaAcademyByAcademy(Integer academyId) {
        if (academyId == null) {
            throw  new IllegalArgumentException("Academy Id cannot be null!");
        }

        return itaAcademyDao.findItaAcademiesByAcademy(academyId);
    }

    @Transactional(readOnly = true)
    public ItaAcademy getItaAcademyById(Integer id) {
        if (id == null) {
            throw  new IllegalArgumentException("ItaAcademy Id cannot be null!");
        }
        ItaAcademy itaAcademy = itaAcademyDao.findOne(id);
        return itaAcademy;
    }

    @Transactional
    public List<User> getAllUsersOfAcademy(Integer academyId) {
        if (academyId == null) {
            throw  new IllegalArgumentException("Academy Id cannot be null!");
        }
        List<User> users = itaAcademyDao.findAllUsersByAcademy(academyId);
        return users;
    }

    @Transactional
    public void updateItaAcademyUserStatus(int itaAcademyStatus, int academyId, int userId) {
        ItaAcademy itaAcademy = itaAcademyDao.findItaAcademyByAcademyAndUser(academyId, userId);
        itaAcademy.setItaAcademyStatus(itaAcademyStatus);
        itaAcademyDao.save(itaAcademy);
    }

}
