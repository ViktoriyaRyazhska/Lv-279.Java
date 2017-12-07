package ua.softserve.service;

import ua.softserve.persistence.entity.StudentStatuses;

public interface StudentsStatusesService {
    StudentStatuses findOne(int id);
}
