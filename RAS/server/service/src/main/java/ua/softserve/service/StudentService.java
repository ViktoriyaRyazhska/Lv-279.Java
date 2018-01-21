package ua.softserve.service;

import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.StudentStatuses;
import ua.softserve.service.dto.EmployeeEngShortDto;
import ua.softserve.service.dto.StudentViewDto;

import java.util.List;

public interface StudentService {

    List<StudentViewDto> getStudentsByAcademy(Integer academyId);

    boolean addStudentsToAcademy(Integer academyId, List<Integer> students);

    boolean removeStudentFromAcademy(Integer studentId);

    boolean updateStudentsOfAcademy(List<StudentViewDto> students);

    Integer countAllByAcademyId(Integer academyId);

    List<EmployeeEngShortDto> getAllEmployees();
}
