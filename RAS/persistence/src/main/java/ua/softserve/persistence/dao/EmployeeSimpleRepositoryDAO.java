package ua.softserve.persistence.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.ItaRole;

import java.util.List;

public interface EmployeeSimpleRepositoryDAO extends Repository<Employee, Integer> {

    Page<Employee> findEmployeesByItaroleRole(String itarole_role, Pageable pageable);
    Page<Employee> findEmployeesByItaroleRoleAndLastnameLike(String itarole_role, String lastname, Pageable pageable);
    Page<Employee> findEmployeesByItaroleRoleAndFirstnameLike(String role,String firstname, Pageable pageable);
    Page<Employee> findEmployeesByItaroleRoleAndFirstnameLikeAndLastnameLike(String itarole_role, String firstname, String lastname, Pageable pageable);
}
