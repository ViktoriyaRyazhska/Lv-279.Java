package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.StudentRepository;
import ua.softserve.persistence.dto.StudentsViewDto;
import ua.softserve.persistence.entity.Student;
import ua.softserve.service.StudentService;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Transactional
    public List<StudentsViewDto> getAllStudentsOfAcademy(Integer academyId) {
        if (academyId == null) {
            throw new IllegalArgumentException("Academy Id cannot be null!");
        }
        //Status 6 means that user is a student of group
        Integer status = 6;

        List<Student> students = studentRepository
                .findAllByItaAcademy_Academy_AcademyIdAndItaAcademy_ItaAcademyStatus(academyId, status);

        List<StudentsViewDto> studentsViewDtos = students.stream().map(x->fromStudentToDto(x)).collect(Collectors.toList());
        return studentsViewDtos;
    }


    private StudentsViewDto fromStudentToDto(Student student) {

        StudentsViewDto studentsViewDto = new StudentsViewDto();

        studentsViewDto.setStudentId(student.getStudentId());
        studentsViewDto.setFirstName(student.getItaAcademy().getUser().getFirstName());
        studentsViewDto.setLastName(student.getItaAcademy().getUser().getLastName());
        studentsViewDto.setEnglishLevel(student.getItaAcademy().getUser().getEnglishLevel());
        studentsViewDto.setTrainingScore(student.getRate());
        studentsViewDto.setTeacherScore(student.getTeacherScore());
        studentsViewDto.setExpertScore(student.getExpertScore());
        //studentsViewDto.setCurrent(student.get);
        studentsViewDto.setTest1(student.getTestOne());
        studentsViewDto.setTest2(student.getTestTwo());
        studentsViewDto.setTest3(student.getTestThree());
        studentsViewDto.setTest4(student.getTestFour());
        studentsViewDto.setTest5(student.getTestFive());
        studentsViewDto.setEntryScore(student.getEntryScore());
        studentsViewDto.setFinalBase(student.getBaseTest());
        studentsViewDto.setFinalLang(student.getFinalTest());
        studentsViewDto.setTest9(student.getTestNine());
        studentsViewDto.setTest10(student.getTestTen());
        studentsViewDto.setEnglishGrammar(student.getLanguage());

        return studentsViewDto;
    }

}
