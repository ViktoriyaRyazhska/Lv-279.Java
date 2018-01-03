package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Student;
import ua.softserve.persistence.entity.StudentStatuses;
import ua.softserve.persistence.repo.EmployeeRepository;
import ua.softserve.persistence.repo.StudentRepository;

import ua.softserve.service.StudentService;
import ua.softserve.service.dto.EmployeeEngShortDto;
import ua.softserve.service.dto.StudentViewDto;

import java.util.List;
import java.util.stream.Collectors;

import static ua.softserve.persistence.constants.ConstantsFromDb.STUDENT_STATUS_TRAINEE_ID;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * Get list of all students subscribed on some group.
     *
     * @param academyId - academy/group id.
     * @return list of StudentsViewDto which will be displayed on UI.
     */
    @Override
    @Transactional
    public List<StudentViewDto> getStudentsByAcademy(Integer academyId) {
        return studentRepository.findAllByAcademyId(academyId).stream()
                .map(StudentViewDto::of)
                .collect(Collectors.toList());
    }

    /**
     * Get list of all Employees
     *
     * @return - list of EmployeeEngShortDto
     * which contains all the necessary information about employee
     * and displayed in the dropdown "Approved By" on UI.
     */
    @Override
    @Transactional
    public List<EmployeeEngShortDto> getAllEmployees() {
        return employeeRepository.findAllSorted().stream()
                .map(EmployeeEngShortDto::of)
                .collect(Collectors.toList());
    }

    /**
     * Sign users to selected group
     *
     * @param academyId - selected group in which we want to add students.
     * @param students - list of users id that ones we want to add to our selected group.
     */
    @Override
    @Transactional
    public void addStudentsToAcademy(Integer academyId, List<Integer> students) {
        List<Student> entities = students.stream().map(id -> {
            Student existStudent = studentRepository.findStudentByAcademy(academyId, id);
            return existStudent == null ? new Student(id, academyId, STUDENT_STATUS_TRAINEE_ID)
                    : existStudent.unremove();
        }).collect(Collectors.toList());
        studentRepository.save(entities);
    }

    /**
     * Remove selected student from list of students.
     *
     * @param studentId - id of student that we want to remove from list of students.
     */
    @Override
    @Transactional
    public void removeStudentFromAcademy(Integer studentId) {
        studentRepository.updateRemovedStatus(studentId, true);
    }

    /**
     * Save data about students to database.
     *
     * @param students - list of StudentViewDto, which contains student activity data while passing the course.
     */
    @Override
    @Transactional
    public void updateStudentsOfAcademy(List<StudentViewDto> students) {
        studentRepository.save(students.stream()
                .map(st -> st.update(studentRepository.findOne(st.getId())))
                .collect(Collectors.toList()));
    }

    /**
     * Save data about student to database.
     *
     * @param student - StudentViewDto, which contains student activity data while passing the course.
     */
    @Override
    @Transactional
    public void updateStudentOfAcademy(StudentViewDto student) {
        studentRepository.save(student.update(studentRepository.findOne(student.getId())));
    }


    /**
     * @param academy
     * @param studentStatuses
     * @return
     */
    @Override
    @Transactional
    public Integer countAllByAcademyAndStudentStatus(Academy academy, StudentStatuses studentStatuses) {
        return studentRepository.countAllByAcademyAndStudentStatus(academy, studentStatuses);
    }

    @Override
    public Integer countAllByAcademyId(Integer academyId) {
        return studentRepository.countAllByAcademy_AcademyIdAndRemovedIsFalse(academyId);
    }
}
