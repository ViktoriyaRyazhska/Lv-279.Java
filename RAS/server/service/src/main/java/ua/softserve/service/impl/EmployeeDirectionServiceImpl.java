//package ua.softserve.service.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//import ua.softserve.persistence.entity.Employee;
//import ua.softserve.persistence.entity.EmployeeDirection;
//import ua.softserve.service.EmployeeDirectionService;
//
//import java.util.List;
//
//@Service
//public class EmployeeDirectionServiceImpl implements EmployeeDirectionService {
//    @Autowired
//    private EmployeeDirectionRepository employeeDirectionRepository;
//
//    @Transactional
//    @Override
//    public void removeGroupEmployee(int id) {
//        employeeDirectionRepository.delete(id);
//    }
//
//    @Override
//    public void addEmployeeToGroup(int group_id, Employee empl,int type_id) {
//        EmployeeDirection employeeDirection = new EmployeeDirection();
//        employeeDirection.setTypeId(type_id);
//        employeeDirection.setEmployee(empl);
//        employeeDirection.setGroupId(group_id);
//
//        employeeDirectionRepository.save(employeeDirection);
//    }
//
//    @Override
//    public List<EmployeeDirection> findAllEmployeesDirectionsByGroupId(int group_id) {
//        return employeeDirectionRepository.findAllByGroupId(group_id);
//    }
//}
