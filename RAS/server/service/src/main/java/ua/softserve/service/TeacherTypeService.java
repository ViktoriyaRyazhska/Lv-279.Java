package ua.softserve.service;

import ua.softserve.persistence.entity.TeacherTypes;

public interface TeacherTypeService {
    TeacherTypes findOne(int id);
}
