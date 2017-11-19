package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Student_Group_Count;

public interface Student_Group_CountDAO extends JpaRepository<Student_Group_Count, Integer> {
}
