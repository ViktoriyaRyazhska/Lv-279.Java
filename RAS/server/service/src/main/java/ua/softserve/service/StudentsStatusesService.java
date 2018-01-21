package ua.softserve.service;

import ua.softserve.persistence.entity.StudentStatuses;

import java.util.List;

public interface StudentsStatusesService {

    List<StudentStatuses> findAll();
}
