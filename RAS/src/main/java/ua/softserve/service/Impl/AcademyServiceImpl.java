package ua.softserve.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.data.entity.Academy;
import ua.softserve.repository.dao.AcademyDAO;
import ua.softserve.service.AcademyService;

import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {
    @Autowired
    AcademyDAO academyDAO;

    @Transactional
    @Override
    public Academy getById(Integer id) {
        return academyDAO.getById(id);
    }

    @Transactional
    @Override
    public List<Academy> getAllAcademys() {
        return academyDAO.getAllAcademys();
    }
}
