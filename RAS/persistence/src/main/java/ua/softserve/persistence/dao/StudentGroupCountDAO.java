package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.StudentGroupCount;

public interface StudentGroupCountDAO extends JpaRepository<StudentGroupCount, Integer> {
}
