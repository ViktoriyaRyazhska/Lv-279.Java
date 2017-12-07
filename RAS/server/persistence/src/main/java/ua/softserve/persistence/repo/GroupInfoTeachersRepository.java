package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.TeacherTypes;

import java.util.List;

public interface GroupInfoTeachersRepository extends JpaRepository<GroupInfoTeachers, Integer> {
    List<GroupInfoTeachers> findAllByAcademyAndTeacherType(Academy academy, TeacherTypes teacherType);

    List<GroupInfoTeachers> findAllByTeacherType(TeacherTypes teacherType);
}
