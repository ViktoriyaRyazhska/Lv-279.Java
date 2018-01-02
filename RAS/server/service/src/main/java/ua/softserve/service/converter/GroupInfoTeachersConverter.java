package ua.softserve.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.GroupInfoTeachers;
import ua.softserve.persistence.repo.TeacherTypeRepository;
import ua.softserve.service.AcademyService;
import ua.softserve.service.EmployeeService;
import ua.softserve.service.dto.GroupInfoTeachersDTO;

import static ua.softserve.persistence.constants.ConstantsFromDb.DEFAULT_CONTRIBUTED_HOURS;
import static ua.softserve.persistence.constants.ConstantsFromDb.DEFAULT_INVOLVED;

@Service
public class GroupInfoTeachersConverter {

    @Autowired
    private AcademyService academyService;
    @Autowired
    private TeacherTypeRepository teacherTypeRepository;
    @Autowired
    private EmployeeService employeeService;

    public GroupInfoTeachers convertDtoToEntity(GroupInfoTeachersDTO groupInfoTeachersDTO){
        GroupInfoTeachers groupInfoTeachers=new GroupInfoTeachers();
        groupInfoTeachers.setAcademy(academyService.findOne(groupInfoTeachersDTO.getAcademy()));
        groupInfoTeachers.setEmployee(employeeService.findOne(groupInfoTeachersDTO.getEmployee()));
        groupInfoTeachers.setTeacherType(teacherTypeRepository.findTeacherTypesByName(groupInfoTeachersDTO.getTeacherType()));
        groupInfoTeachers.setInvolved(DEFAULT_INVOLVED);
        groupInfoTeachers.setContributedHours(DEFAULT_CONTRIBUTED_HOURS);
        return groupInfoTeachers;
    }
}
