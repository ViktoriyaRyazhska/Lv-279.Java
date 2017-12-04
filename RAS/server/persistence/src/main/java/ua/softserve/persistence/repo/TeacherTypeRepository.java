package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.TeacherTypes;

public interface TeacherTypeRepository extends JpaRepository<TeacherTypes, Integer>{
}
