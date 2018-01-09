package ua.softserve.service;

import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.TeacherTypes;
import ua.softserve.service.dto.GroupInfoTeachersDTO;

import java.util.List;

public interface GroupInfoTeachersService {
    List<GroupInfoTeachers> findAllByAcademyAndTeacherType(Academy academy, TeacherTypes teacherType);

    List<GroupInfoTeachers> findAllByTeacherType(TeacherTypes teacherType);

    Boolean isAssignToGroup(Integer id);

    void save(List<GroupInfoTeachersDTO> object);

    List<GroupInfoTeachers> findAllByAcademy_AcademyId(Integer academy_academyId);

    void updateGroupInfoTeachers(List<GroupInfoTeachers> groupInfoTeachers);

    void deleteGroupInfoTeachers(Integer id);
}
