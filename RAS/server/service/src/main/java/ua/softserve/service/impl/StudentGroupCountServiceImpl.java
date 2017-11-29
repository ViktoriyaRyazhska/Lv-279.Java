package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.StudentGroupCountRepository;
import ua.softserve.persistence.entity.StudentGroupCount;
import ua.softserve.service.StudentGroupCountService;
import ua.softserve.service.dto.AcademyDTO;

import java.util.List;

@Service
public class StudentGroupCountServiceImpl implements StudentGroupCountService {
    @Autowired
    StudentGroupCountRepository studentGroupCountRepository;

    @Transactional
    @Override
    public void save(StudentGroupCount studentGroupCount) {
        studentGroupCountRepository.save(studentGroupCount);
    }

    @Transactional
    @Override
    public StudentGroupCount saveDTO(AcademyDTO academyDTO) {
        StudentGroupCount studentGroupCount;
        if (academyDTO.getStudentPlannedToGraduate() < 1) {
            throw new IllegalArgumentException("Field \'Students Planned to Graduate\' can't be less than 1");
        }
        if (academyDTO.getStudentPlannedToEnrollment() < 1) {
            throw new IllegalArgumentException("Field \'Students Planned to Enrollment\' can't be less than 1");
        }
        if (academyDTO.getStudentActual() < 1) {
            throw new IllegalArgumentException("Field \'Students Actual\' can't be less than 1");
        } else {
            studentGroupCount = new StudentGroupCount();
            studentGroupCount.setStudentsPlannedToGraduate(academyDTO.getStudentPlannedToGraduate());
            studentGroupCount.setStudentsPlannedToEnrollment(academyDTO.getStudentPlannedToEnrollment());
            studentGroupCount.setStudentsActual(academyDTO.getStudentActual());
            save(studentGroupCount);
            return studentGroupCount;
        }
    }

    @Override
    public StudentGroupCount findOne(int id) {
        return studentGroupCountRepository.findOne(id);
    }

    @Override
    public List<StudentGroupCount> findAll() {
        return studentGroupCountRepository.findAll();
    }

    @Transactional
    @Override
    public void remove(StudentGroupCount studentGroupCount) {
        studentGroupCountRepository.delete(studentGroupCount);
    }
}
