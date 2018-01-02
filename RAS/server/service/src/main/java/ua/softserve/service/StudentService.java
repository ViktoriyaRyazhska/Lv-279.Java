package ua.softserve.service;

import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.StudentStatuses;
import ua.softserve.service.dto.EmployeeEngShortDto;
import ua.softserve.service.dto.StudentViewDto;

import java.util.List;

public interface StudentService {

    /**
     * Returns accepted students by academy id
     *
     * @param academyId - academy/group id
     * @return list of students
     */
    List<StudentViewDto> getStudentsByAcademy(Integer academyId);

    void addStudentsToAcademy(Integer academyId, List<Integer> students);

    void removeStudentFromAcademy(Integer studentId);

    void updateStudentsOfAcademy(List<StudentViewDto> students);

    void updateStudentOfAcademy(StudentViewDto student);

    Integer countAllByAcademyAndStudentStatus(Academy academy, StudentStatuses studentStatuses);

    List<EmployeeEngShortDto> getAllEmployees();
}
