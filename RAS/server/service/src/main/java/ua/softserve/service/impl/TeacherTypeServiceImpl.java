package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.TeacherTypes;
import ua.softserve.persistence.repo.TeacherTypeRepository;
import ua.softserve.service.TeacherTypeService;

@Service
public class TeacherTypeServiceImpl implements TeacherTypeService{
    @Autowired
    private TeacherTypeRepository teacherTypeRepository;

    @Override
    public TeacherTypes findOne(int id) {
        return teacherTypeRepository.findOne(id);
    }
}
