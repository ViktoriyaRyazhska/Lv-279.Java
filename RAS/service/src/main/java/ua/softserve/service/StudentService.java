package ua.softserve.service;

import ua.softserve.persistence.dto.StudentsViewDto;
import ua.softserve.persistence.entity.Student;

import java.util.List;

public interface StudentService {

    List<StudentsViewDto> getAllStudentsOfAcademy(Integer academyId);

    StudentsViewDto fromStudentToDto(Student student);

    void saveResults(StudentsViewDto studentsViewDto);
}
