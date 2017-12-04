package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.Employee;

import javax.validation.constraints.NotNull;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{

}
