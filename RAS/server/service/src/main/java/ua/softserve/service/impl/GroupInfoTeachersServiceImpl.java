package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.LoginUser;
import ua.softserve.persistence.entity.TeacherTypes;
import ua.softserve.persistence.repo.GroupInfoTeachersRepository;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.GroupInfoTeachersService;
import ua.softserve.service.converter.GroupInfoTeachersConverter;
import ua.softserve.service.dto.GroupInfoTeachersDTO;

import java.util.List;
import java.util.Optional;

@Service
public class GroupInfoTeachersServiceImpl implements GroupInfoTeachersService {
    @Autowired
    private GroupInfoTeachersRepository groupInfoTeachersRepository;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private GroupInfoTeachersConverter groupInfoTeachersConverter;

    @Override
    public List<GroupInfoTeachers> findAllByAcademyAndTeacherType(Academy academy, TeacherTypes teacherType) {
        return groupInfoTeachersRepository.findAllByAcademyAndTeacherType(academy, teacherType);
    }

    @Override
    public List<GroupInfoTeachers> findAllByTeacherType(TeacherTypes teacherType) {
        return groupInfoTeachersRepository.findAllByTeacherType(teacherType);
    }

    @Override
    public Boolean isAssignToGroup(Integer id) {
        for (GroupInfoTeachers groupInfoTeachers : groupInfoTeachersRepository.findAllByAcademy_AcademyId(id)) {
            if (groupInfoTeachers.getEmployee().getEmployeeId().equals
                    (employeeService.findEmployeesByLoginUserId(((Optional<LoginUser>) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).get()
                            .getId()).getEmployeeId())) {
                return true;
            }
        }
        return false;
    }

    @Transactional
    @Override
    public void save(List<GroupInfoTeachersDTO> object) {
        object.stream().forEach(groupInfoTeachersDTO -> {
            groupInfoTeachersRepository.save(groupInfoTeachersConverter.convertDtoToEntity(groupInfoTeachersDTO));
        });
    }

    @Override
    public List<GroupInfoTeachers> findAllByAcademy_AcademyId(Integer academy_academyId) {
        return groupInfoTeachersRepository.findAllByAcademy_AcademyId(academy_academyId);
    }

    @Transactional
    @Override
    public void updateGroupInfoTeachers(List<GroupInfoTeachers> groupInfoTeachers) {
        groupInfoTeachersRepository.save(groupInfoTeachers);
    }
}
