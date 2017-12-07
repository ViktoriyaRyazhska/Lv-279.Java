package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.Student;

import ua.softserve.persistence.entity.StudentStatuses;
import ua.softserve.persistence.repo.StudentRepository;

import ua.softserve.service.StudentService;
import ua.softserve.service.dto.StudentViewDto;


import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

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
                        .map(id -> new Student(id, academyId))
                        .collect(Collectors.toList()));
    }

    @Override
    @Transactional
    public void deleteStudentFromAcademy(Integer studentId) {
        Student student = studentRepository.getOne(studentId);
        student.setRemoved(true);
        studentRepository.save(student);
    }

    @Override
    @Transactional
    public Integer countAllByAcademyAndStudentStatus(Academy academy, StudentStatuses studentStatuses) {
        return studentRepository.countAllByAcademyAndStudentStatus(academy, studentStatuses);
    }
}
