package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Student;
import ua.softserve.persistence.entity.StudentStatuses;
import ua.softserve.persistence.repo.EmployeeRepository;
import ua.softserve.persistence.repo.StudentRepository;
import ua.softserve.persistence.repo.StudentsStatusesRepository;
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
    private StudentsStatusesRepository studentsStatusesRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StudentViewDto> getStudentsByAcademy(Integer academyId) {
        return studentRepository.findAllByAcademyId(academyId)
                .stream()
                .map(StudentViewDto::of)
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeEngShortDto> getAllEmployees() {
        return employeeRepository.findAllSorted()
                .stream()
                .map(EmployeeEngShortDto::of)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addStudentsToAcademy(Integer academyId, List<Integer> students) {
        StudentStatuses studentStatuses = studentsStatusesRepository
                .findOne(STUDENT_STATUS_TRAINEE_ID);
        List<Student> entities = students.stream()
                .map(id -> {
                    Student existStudent = studentRepository
                            .findStudentByAcademy(academyId, id);
                    return existStudent == null ?
                            new Student(id, academyId) : existStudent.unremove();
                })
                .peek(student -> student.setStudentStatus(studentStatuses))
                .collect(Collectors.toList());
        studentRepository.save(entities);
    }

    @Override
    @Transactional
    public void removeStudentFromAcademy(Integer studentId) {
        Student student = studentRepository.getOne(studentId);
        student.setRemoved(true);
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public void updateStudentOfAcademy(List<StudentViewDto> students) {
        studentRepository.save(students
                .stream()
                .map(st -> st
                        .update(studentRepository
                                .findOne(st.getId())))
                .collect(Collectors.toList()));
    }

    @Override
    @Transactional
    public Integer countAllByAcademyAndStudentStatus(Academy academy, StudentStatuses studentStatuses) {
        return studentRepository.countAllByAcademyAndStudentStatus(academy, studentStatuses);
    }
}
