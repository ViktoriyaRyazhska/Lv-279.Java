package ua.softserve.service;

import ua.softserve.persistence.dto.StudentsShortViewDto;
import ua.softserve.persistence.dto.StudentsViewDto;
import ua.softserve.persistence.entity.Student;

import java.util.List;

public interface StudentService {

    /**
     * Returns accepted students by academy id
     *
     * @param academyId - academy/group id
     * @return list of students
     */
    List<StudentsViewDto> getAcceptedStudentsOfAcademy(Integer academyId);

    /**
     * Returns all non-accepted students by academy id
     *
     * @param academyId - academy/group id
     * @return list of students
     */
    List<StudentsShortViewDto> getStudentsOfAcademy(Integer academyId);

    void deleteStudentsFromAcademy(Integer academyId, List<Integer> userIds);

    void addStudentsToAcademy(Integer academyId, List<Integer> userIds);

    void saveResults(StudentsViewDto studentsViewDto);

    void saveAllStudents(List<StudentsViewDto> studentsViewDto);

    Student findById(Integer studentId);

    List<Student> getStudentFromGroup(Integer groupId);

    Student save(Student student);
}
