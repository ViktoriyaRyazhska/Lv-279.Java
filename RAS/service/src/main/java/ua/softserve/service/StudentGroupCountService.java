package ua.softserve.service;

import ua.softserve.persistence.entity.StudentGroupCount;

import java.util.List;

public interface StudentGroupCountService {
    void save(StudentGroupCount user);

    StudentGroupCount findOne(int id);

    List<StudentGroupCount> findAll();

    void remove(StudentGroupCount user);
}
