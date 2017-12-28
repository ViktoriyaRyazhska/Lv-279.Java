package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.LoginUser;
import ua.softserve.persistence.entity.TeacherTypes;
import ua.softserve.persistence.repo.GroupInfoTeachersRepository;
import ua.softserve.service.GroupInfoTeachersService;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Boolean isAssignToGroup(Integer id) {
        Optional<LoginUser> principal = (Optional<LoginUser>) SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        for (GroupInfoTeachers groupInfoTeachers : groupInfoTeachersRepository.findAllByAcademy_AcademyId(id)) {
            if (groupInfoTeachers.getEmployee().getEmployeeId().equals(
                    ((Optional<LoginUser>) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).get()
                            .getId())) {
                return true;
            }
        }
        return false;
    }
}
