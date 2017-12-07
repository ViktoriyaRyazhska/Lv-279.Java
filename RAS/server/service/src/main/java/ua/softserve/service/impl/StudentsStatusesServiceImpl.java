package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.persistence.entity.StudentStatuses;
import ua.softserve.persistence.repo.StudentsStatusesRepository;
import ua.softserve.service.StudentsStatusesService;

@Service
public class StudentsStatusesServiceImpl implements StudentsStatusesService {
    @Autowired
    private StudentsStatusesRepository studentsStatusesRepository;

    @Override
    public StudentStatuses findOne(int id) {
        return studentsStatusesRepository.findOne(id);
    }
}
