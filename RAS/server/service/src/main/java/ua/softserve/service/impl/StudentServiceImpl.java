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

@Service
public class StudentServiceImpl implements StudentService {

    public static final Integer STATUS_OF_TRAINEE = 1;
    public static final Integer ZERO_EMPLOYEE = 0;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentsStatusesRepository studentsStatusesRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StudentViewDto> getStudentsByAcademy(Integer academyId) {
        return studentRepository
                .findAllByAcademyId(academyId)
                .stream()
                .map(StudentViewDto::of)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addStudentsToAcademy(Integer academyId, List<Integer> students) {
        studentRepository
                .save(students
                        .stream()
                        .map(id -> {
                            Student existStudent = studentRepository
                                    .ifStudentExist(academyId, id);
                            return existStudent == null ?
                                    new Student(id, academyId) : existStudent.unRemove();
                        })
                        .peek(student -> student
                                .setStudentStatus(studentsStatusesRepository
                                        .findOne(STATUS_OF_TRAINEE)))
                        .collect(Collectors.toList()));
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
        students.forEach(st -> {
            EmployeeEngShortDto approvedBy = st.getApprovedBy();
            studentRepository
                    .save(st.update(studentRepository
                            .findOne(st.getId())
                            .setApprovedBy(employeeRepository
                                    .findOne(approvedBy == null ? ZERO_EMPLOYEE : approvedBy.getEmployeeId()))));
        });
    }

    @Override
    @Transactional
    public Integer countAllByAcademyAndStudentStatus(Academy academy, StudentStatuses studentStatuses) {
        return studentRepository
                .countAllByAcademyAndStudentStatus(academy, studentStatuses);
    }
}
