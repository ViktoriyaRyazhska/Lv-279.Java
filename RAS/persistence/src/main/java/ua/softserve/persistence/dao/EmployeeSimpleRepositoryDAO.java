package ua.softserve.persistence.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;
import ua.softserve.persistence.entity.Employee;

import java.util.List;

public interface EmployeeSimpleRepositoryDAO extends Repository<Employee, Integer> {

    Page<Employee> findEmployeesByItaroleRole(String itarole_role, Pageable pageable);
    Page<Employee> findEmployeesByItaroleRoleAndFirstnameOrLastnameLike(String itarole_role, String firstname, String lastname, Pageable pageable);
}
