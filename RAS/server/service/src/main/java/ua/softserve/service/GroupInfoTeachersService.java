package ua.softserve.service;

import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.TeacherTypes;

import java.util.List;

public interface GroupInfoTeachersService {
    List<GroupInfoTeachers> findAllByAcademyAndTeacherType(Academy academy, TeacherTypes teacherType);

    List<GroupInfoTeachers> findAllByTeacherType(TeacherTypes teacherType);
}
