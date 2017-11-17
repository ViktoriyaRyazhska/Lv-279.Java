package ua.softserve.repository.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.data.entity.Employee;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee,Integer>{

    @Query("from Employee e join fetch e.itarole where e.itarole.emrole=:role")
    List<Employee> findEmployeesWithItaRoles(@Param("role") String role);
}
