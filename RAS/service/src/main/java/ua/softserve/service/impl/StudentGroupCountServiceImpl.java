package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.StudentGroupCountDAO;
import ua.softserve.persistence.dto.AcademyDTO;
import ua.softserve.persistence.entity.StudentGroupCount;
import ua.softserve.service.StudentGroupCountService;

import java.util.List;

@Service
public class StudentGroupCountServiceImpl implements StudentGroupCountService {
    @Autowired
    StudentGroupCountDAO studentGroupCountDAO;

    @Transactional
    @Override
    public void save(StudentGroupCount studentGroupCount) {
        studentGroupCountDAO.save(studentGroupCount);
    }

    @Transactional
    @Override
    public StudentGroupCount saveDTO(AcademyDTO academyDTO){
        StudentGroupCount studentGroupCount = new StudentGroupCount();
        studentGroupCount.setStudentsPlannedToGraduate(academyDTO.getStudentsPlannedToGraduate());
        studentGroupCount.setStudentsPlannedToEnrollment(academyDTO.getStudentsPlannedToEnrollment());
        studentGroupCount.setStudentsActual(academyDTO.getStudentsActual());
        save(studentGroupCount);
        return studentGroupCount;
    }

    @Override
    public StudentGroupCount findOne(int id) {
        return studentGroupCountDAO.findOne(id);
    }

    @Override
    public List<StudentGroupCount> findAll() {
        return studentGroupCountDAO.findAll();
    }

    @Transactional
    @Override
    public void remove(StudentGroupCount studentGroupCount) {
        studentGroupCountDAO.delete(studentGroupCount);
    }
}
