package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.EmployeeDirection;

import java.util.List;

public interface EmployeeDirectionRepository extends JpaRepository<EmployeeDirection, Integer> {
    List<EmployeeDirection> findAllByGroupId(int group_id);
}
