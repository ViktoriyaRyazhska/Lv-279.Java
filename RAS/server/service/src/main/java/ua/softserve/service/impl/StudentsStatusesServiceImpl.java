package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.StudentStatuses;
import ua.softserve.persistence.repo.StudentsStatusesRepository;
import ua.softserve.service.StudentsStatusesService;

import java.util.List;

@Service
public class StudentsStatusesServiceImpl implements StudentsStatusesService {
    @Autowired
    private StudentsStatusesRepository studentsStatusesRepository;

    @Override
    public List<StudentStatuses> findAll() {
        return studentsStatusesRepository.findAll();
    }

    @Override
    public StudentStatuses findOne(int id) {
        return studentsStatusesRepository.findOne(id);
    }
}
