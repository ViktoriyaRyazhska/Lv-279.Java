package ua.softserve.service;

import ua.softserve.persistence.dto.AcademyDTO;
import ua.softserve.persistence.entity.StudentGroupCount;

import java.util.List;

public interface StudentGroupCountService {
    void save(StudentGroupCount studentGroupCount);

    StudentGroupCount saveDTO(AcademyDTO academyDTO);

    StudentGroupCount findOne(int id);

    List<StudentGroupCount> findAll();

    void remove(StudentGroupCount studentGroupCount);
}
