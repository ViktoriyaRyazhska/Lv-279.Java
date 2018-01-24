package ua.softserve.service.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Student;
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
    private static final Logger logger = LogManager.getLogger(StudentServiceImpl.class);

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
        return studentRepository.findAllByAcademyAcademyIdAndRemovedIsFalse(academyId).stream()
                .map(StudentViewDto::of)
                .collect(Collectors.toList());
    }

    /**
     * Get list of all Employees
     *
     * @return list of EmployeeEngShortDto
     * which contains all the necessary information about employee
     * and displayed in the dropdown "Approved By" on UI.
     */
    @Override
    @Transactional
    public List<EmployeeEngShortDto> getAllEmployees() {
        return employeeRepository.findAllByOrderByLastNameEngAscFirstNameEngAsc().stream()
                .map(EmployeeEngShortDto::of)
                .collect(Collectors.toList());
    }

    /**
     * Sign users to selected group
     *
     * @param academyId - selected group in which we want to add students.
     * @param students  - list of users id that ones we want to add to our selected group.
     */
    @Override
    @Transactional
    public boolean addStudentsToAcademy(Integer academyId, List<Integer> students) {
        try {
            List<Student> entities = students.stream().map(id -> {
                Student existStudent = studentRepository.findStudentByAcademyAcademyIdAndUserId(academyId, id);
                return existStudent == null ? new Student(id, academyId, STUDENT_STATUS_TRAINEE_ID)
                        : existStudent.unremove();
            }).collect(Collectors.toList());
            studentRepository.save(entities);
        } catch (RuntimeException e) {
            logger.catching(e);
            return false;
        }
        return true;
    }

    /**
     * Remove selected student from list of students.
     *
     * @param studentId - id of student that we want to remove from list of students.
     */
    @Override
    @Transactional
    public boolean removeStudentFromAcademy(Integer studentId) {
        try {
            Student existStudent = studentRepository.findOne(studentId);
            existStudent.setRemoved(true);
            studentRepository.save(existStudent);
        } catch (RuntimeException e) {
            logger.catching(e);
            return false;
        }
        return true;
    }

    /**
     * Save data about students to database.
     *
     * @param students - list of StudentViewDto, which contains student activity data while passing the course.
     */
    @Override
    @Transactional
    public boolean updateStudentsOfAcademy(List<StudentViewDto> students) {
        try {
            studentRepository.save(students.stream()
                    .map(st -> st.update(studentRepository.findOne(st.getId())))
                    .collect(Collectors.toList()));
        } catch (RuntimeException e) {
            logger.catching(e);
            return false;
        }
        return true;
    }

    /**
     * Count existing students in the selected group.
     *
     * @param academyId - selected group in which we want to count students.
     * @return number of existing students in the selected group.
     */
    @Override
    public Integer countAllByAcademyId(Integer academyId) {
        return studentRepository.countAllByAcademyAcademyIdAndRemovedIsFalse(academyId);
    }
}
