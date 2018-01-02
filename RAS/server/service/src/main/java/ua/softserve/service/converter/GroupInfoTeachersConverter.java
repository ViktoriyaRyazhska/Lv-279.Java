package ua.softserve.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.service.AcademyService;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.dto.GroupInfoTeachersDTO;

@Service
public class GroupInfoTeachersConverter {

    @Autowired
    private AcademyService academyService;

    @Autowired
    private EmployeeService employeeService;

    public GroupInfoTeachers convertDtoToEntity(GroupInfoTeachersDTO groupInfoTeachersDTO){
        GroupInfoTeachers groupInfoTeachers=new GroupInfoTeachers();
        groupInfoTeachers.setAcademy(academyService.findOne(groupInfoTeachersDTO.getAcademy()));
        groupInfoTeachers.setEmployee(employeeService.findOne(groupInfoTeachersDTO.getEmployee()));
        groupInfoTeachers.setInvolved(0);
        groupInfoTeachers.setContributedHours(0);
        return groupInfoTeachers;
    }
}
