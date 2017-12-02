package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.GroupInfoTeachers;

import java.util.List;

public interface GroupInfoTeachersRepository extends JpaRepository<GroupInfoTeachers,Integer>{

}
