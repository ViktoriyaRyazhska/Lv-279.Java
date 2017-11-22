package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.dao.StudentGroupCountDAO;
import ua.softserve.persistence.entity.StudentGroupCount;
import ua.softserve.service.StudentGroupCountService;

import java.util.List;

@Service
public class StudentGroupCountServiceImpl implements StudentGroupCountService {
    @Autowired
    StudentGroupCountDAO studentGroupCountDAO;

    @Override
    public void save(StudentGroupCount studentGroupCount) {
        studentGroupCountDAO.save(studentGroupCount);
    }

    @Override
    public StudentGroupCount findOne(int id) {
        return studentGroupCountDAO.findOne(id);
    }

    @Override
    public List<StudentGroupCount> findAll() {
        return studentGroupCountDAO.findAll();
    }

    @Override
    public void remove(StudentGroupCount studentGroupCount) {
        studentGroupCountDAO.delete(studentGroupCount);
    }
}
