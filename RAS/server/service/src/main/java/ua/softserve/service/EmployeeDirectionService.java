package ua.softserve.service;

import ua.softserve.persistence.entity.Employee;
import ua.softserve.persistence.entity.EmployeeDirection;

import java.util.List;

public interface EmployeeDirectionService {
    List<EmployeeDirection> findAllEmployeesDirectionsByGroupId(int group_id);
    void removeGroupEmployee (int id);
    void addEmployeeToGroup(int group_id, Employee empl, int type_id);
}
