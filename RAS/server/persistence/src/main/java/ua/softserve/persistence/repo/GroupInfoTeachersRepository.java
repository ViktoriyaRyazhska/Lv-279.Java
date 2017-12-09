package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.TeacherTypes;

import java.util.List;

public interface GroupInfoTeachersRepository extends JpaRepository<GroupInfoTeachers, Integer> {
    List<GroupInfoTeachers> findAllByAcademyAndTeacherType(Academy academy, TeacherTypes teacherType);

    @Query(value = "select * from group_info_teachers git where git.academy_id = :aid" +
            " and git.teacher_type_id = :ttid", nativeQuery = true)
    List<GroupInfoTeachers> findAllByAcademyIdAndTeacherTypeId
            (@Param("aid") Integer aid, @Param("ttid") Integer ttid);

    List<GroupInfoTeachers> findAllByTeacherType(TeacherTypes teacherType);

    List<GroupInfoTeachers> findAllByAcademyAcademyId(int id);

}
