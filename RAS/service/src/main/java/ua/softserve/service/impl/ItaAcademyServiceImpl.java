package ua.softserve.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.dao.ItaAcademyRepository;
import ua.softserve.persistence.entity.ItaAcademy;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.AcademyService;
import ua.softserve.service.ItaAcademyService;

import org.springframework.transaction.annotation.Transactional;
import ua.softserve.service.StudentService;

import java.util.List;

@Service
public class ItaAcademyServiceImpl implements ItaAcademyService {

    public final static int STATUS_OF_STUDENT_IN_GROUP = 6;
    public final static int STATUS_OF_REJECTED_STUDENT_IN_GROUP = 8;

    @Autowired
    private ItaAcademyRepository itaAcademyRepository;

    @Autowired
    private AcademyService academyService;

    @Transactional(readOnly = true)
    public List<ItaAcademy> getAllItaAcademyByAcademy(Integer academyId) {
        if (academyId == null) {
            throw new IllegalArgumentException("Academy Id cannot be null!");
        }

        return itaAcademyRepository.findAllByAcademy_AcademyId(academyId);
    }

    @Transactional(readOnly = true)
    public ItaAcademy getItaAcademyById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ItaAcademy Id cannot be null!");
        }
        ItaAcademy itaAcademy = itaAcademyRepository.findOne(id);
        return itaAcademy;
    }

    @Transactional
    public List<User> getAllUsersOfAcademy(Integer academyId) {
        if (academyId == null) {
            throw new IllegalArgumentException("Academy Id cannot be null!");
        }
        List<User> users = itaAcademyRepository.findAllUsersByAcademy(academyId);
        return users;
    }


    private void setUserStatusInAcademy(Integer academyId, Integer userId, Integer status) {
        ItaAcademy itaAcademy = itaAcademyRepository.findItaAcademyByAcademyAndUser(academyId, userId);
        if (itaAcademy != null) {
            itaAcademy.setItaAcademyStatus(status);
            itaAcademyRepository.save(itaAcademy);
        }
    }


    @Transactional
    @Override
    public void addUserInAcademy(Integer academyId, Integer userId) {
        if (academyId == null) {
            throw new IllegalArgumentException("Academy Id cannot be null!");
        }
        if (userId == null) {
            throw new IllegalArgumentException("User Id cannot be null!");
        }
        setUserStatusInAcademy(academyId, userId, STATUS_OF_STUDENT_IN_GROUP);

        int studentCount = academyService.getById(academyId).getStudentGroupCount().getStudentsActual();
        academyService.getById(academyId).getStudentGroupCount().setStudentsActual(++studentCount);
    }

    @Transactional
    @Override
    public void deleteUserInAcademy(Integer academyId, Integer userId) {
        if (academyId == null) {
            throw new IllegalArgumentException("Academy Id cannot be null!");
        }
        if (userId == null) {
            throw new IllegalArgumentException("User Id cannot be null!");
        }
        setUserStatusInAcademy(academyId, userId, STATUS_OF_REJECTED_STUDENT_IN_GROUP);

        int studentCount = academyService.getById(academyId).getStudentGroupCount().getStudentsActual();
        if (studentCount > 0) {
            academyService.getById(academyId).getStudentGroupCount().setStudentsActual(--studentCount);
        }
    }


}
