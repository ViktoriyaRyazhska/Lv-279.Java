package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.StudentRepository;
import ua.softserve.service.dto.StudentsShortViewDto;
import ua.softserve.service.dto.StudentsViewDto;
import ua.softserve.persistence.entity.Student;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    public final static int STATUS_OF_STUDENT_IN_GROUP = 6;
    public final static int STATUS_OF_REJECTED_STUDENT_IN_GROUP = 8;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    @Transactional(readOnly = true)
    public List<StudentsViewDto> getAcceptedStudentsOfAcademy(Integer academyId) {
        if (academyId == null) {
            throw new IllegalArgumentException("Academy Id cannot be null!");
        }

        return studentRepository
                .findStudentsByAcademyAndStatus(academyId, STATUS_OF_STUDENT_IN_GROUP)
                .stream()
                .map(this::fromStudentToDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentsShortViewDto> getStudentsOfAcademy(Integer academyId) {
        if (academyId == null) {
            throw new IllegalArgumentException("Academy Id cannot be null!");
        }

        return studentRepository
                .findStudentsByAcademyAndStatusNot(academyId, STATUS_OF_STUDENT_IN_GROUP)
                .stream()
                .map(this::fromStudentToShortDto)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public void addStudentsToAcademy(Integer academyId, List<Integer> userIds) {
        if (academyId == null) {
            throw new IllegalArgumentException("Academy Id cannot be null!");
        }
        studentRepository.updateItaStatus(STATUS_OF_STUDENT_IN_GROUP, academyId, userIds);
    }

    @Override
    @Transactional
    public void deleteStudentsFromAcademy(Integer academyId, List<Integer> userIds) {
        if (academyId == null) {
            throw new IllegalArgumentException("Academy Id cannot be null!");
        }
        studentRepository.updateItaStatus(STATUS_OF_REJECTED_STUDENT_IN_GROUP, academyId, userIds);
    }

    @Transactional
    @Override
    public void saveAllStudents(List<StudentsViewDto> studentsViewDto) {
        studentsViewDto.forEach(this::saveResults);
    }

    private StudentsShortViewDto fromStudentToShortDto(Student student) {
        StudentsShortViewDto dto = new StudentsShortViewDto();
        User u = student.getItaAcademy().getUser();
        dto.setId(u.getId());
        dto.setFullName(u.getFirstName() + " " + u.getLastName());
        return dto;
    }

    private StudentsViewDto fromStudentToDto(Student student) {
        StudentsViewDto dto = new StudentsViewDto();
        User u = student.getItaAcademy().getUser();
        dto.setStudentId(u.getId());
        dto.setFullName(u.getFirstName() + " " + u.getLastName());
        dto.setEnglishLevel(u.getEnglishLevel());
        dto.setTrainingScore(student.getRate());
        dto.setTeacherScore(student.getTeacherScore());
        dto.setExpertScore(student.getExpertScore());
        //dto.setCurrent(student.get);
        dto.setTest1(student.getTestOne());
        dto.setTest2(student.getTestTwo());
        dto.setTest3(student.getTestThree());
        dto.setTest4(student.getTestFour());
        dto.setTest5(student.getTestFive());
        dto.setEntryScore(student.getEntryScore());
        dto.setFinalBase(student.getBaseTest());
        dto.setFinalLang(student.getFinalTest());
        dto.setTest9(student.getTestNine());
        dto.setTest10(student.getTestTen());
        dto.setEnglishGrammar(student.getLanguage());
        dto.setTeacherFeedback(student.getTeacherFeedback());
        dto.setExpertFeedback(student.getExpertFeedback());

        return dto;
    }

    @Transactional
    public void saveResults(StudentsViewDto studentsViewDto) {
        if (studentsViewDto == null) {
            throw new IllegalArgumentException("Student cannot be null!");
        }

        Student student = studentRepository.findOne(studentsViewDto.getStudentId());
        student.setTestOne(studentsViewDto.getTest1());
        student.setTestTwo(studentsViewDto.getTest2());
        student.setTestThree(studentsViewDto.getTest3());
        student.setTestFour(studentsViewDto.getTest4());
        student.setTestFive(studentsViewDto.getTest5());
        student.setTestNine(studentsViewDto.getTest9());
        student.setTestTen(studentsViewDto.getTest10());
        student.setTeacherScore(studentsViewDto.getTeacherScore());
        student.setExpertScore(studentsViewDto.getExpertScore());
        student.setInterviewerScore(studentsViewDto.getInterviewerScore());
        student.setTeacherFeedback(studentsViewDto.getTeacherFeedback());
        student.setExpertFeedback(studentsViewDto.getExpertFeedback());
        studentRepository.save(student);
    }

    @Transactional
    @Override
    public Student findById(Integer studentId) {
        return studentRepository.findOne(studentId);
    }

    @Transactional
    @Override
    public List<Student> getStudentFromGroup(Integer groupId) {
        return studentRepository.findStudentsByAcademyAndStatus(groupId , STATUS_OF_STUDENT_IN_GROUP);
    }

    @Transactional
    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }


}
