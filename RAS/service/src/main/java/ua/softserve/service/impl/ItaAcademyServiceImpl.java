package ua.softserve.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.dao.ItaAcademyDao;
import ua.softserve.persistence.entity.ItaAcademy;
import ua.softserve.service.ItaAcademyService;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItaAcademyServiceImpl implements ItaAcademyService {

    @Autowired
    private ItaAcademyDao itaAcademyDao;

    @Transactional
    public List<ItaAcademy> getAllByAcademy(int academyId) {

        return itaAcademyDao.findItaAcademiesByAcademy(academyId);
    }

    @Transactional
    public ItaAcademy getItaAcademyById(int id) {
        return itaAcademyDao.getOne(id);
    }


    @Transactional
    public void updateItaAcademyUserStatus(int itaAcademyStatus, int academyId, int userId) {
        ItaAcademy itaAcademy = itaAcademyDao.findItaAcademyByAcademyAndUser(academyId,userId);
        itaAcademy.setItaAcademyStatus(itaAcademyStatus);
        itaAcademyDao.save(itaAcademy);
    }

}
