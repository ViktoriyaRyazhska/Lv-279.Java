package ua.softserve.persistence.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee,Integer> {

    @Query("from Employee e join fetch e.itarole where e.itarole.role=:role")
    List<Employee> findEmployeesWithItaRoles(@Param("role") String role);
    Page<Employee> findEmployeesByItaroleRole(String itarole_role, Pageable pageable);
    Page<Employee> findEmployeesByItaroleRoleAndLastnameLike(String itarole_role, String lastname, Pageable pageable);
    Page<Employee> findEmployeesByItaroleRoleAndFirstnameLike(String role,String firstname, Pageable pageable);
    Page<Employee> findEmployeesByItaroleRoleAndFirstnameLikeAndLastnameLike(String itarole_role, String firstname, String lastname, Pageable pageable);
}