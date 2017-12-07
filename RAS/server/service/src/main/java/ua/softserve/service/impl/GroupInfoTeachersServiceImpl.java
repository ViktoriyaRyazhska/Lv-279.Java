package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.TeacherTypes;
import ua.softserve.persistence.repo.GroupInfoTeachersRepository;
import ua.softserve.service.GroupInfoTeachersService;

import java.util.List;

@Service
public class GroupInfoTeachersServiceImpl implements GroupInfoTeachersService {
    @Autowired
    private GroupInfoTeachersRepository groupInfoTeachersRepository;

    @Override
    public List<GroupInfoTeachers> findAllByAcademyAndTeacherType(Academy academy, TeacherTypes teacherType) {
        return groupInfoTeachersRepository.findAllByAcademyAndTeacherType(academy, teacherType);
    }

    @Override
    public List<GroupInfoTeachers> findAllByTeacherType(TeacherTypes teacherType) {
        return groupInfoTeachersRepository.findAllByTeacherType(teacherType);
    }
}
