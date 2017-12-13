package ua.softserve.service;

import ua.softserve.persistence.entity.StudentStatuses;

import java.util.List;

public interface StudentsStatusesService {
    StudentStatuses findOne(int id);

    List<StudentStatuses> findAll();
}
