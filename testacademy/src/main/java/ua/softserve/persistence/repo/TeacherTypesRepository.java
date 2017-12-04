package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.entity.TeacherTypes;

public interface TeacherTypesRepository extends JpaRepository<TeacherTypes,Integer>{

}
