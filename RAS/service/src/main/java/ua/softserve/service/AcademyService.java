package ua.softserve.service;


import ua.softserve.persistence.entity.Academy;

import java.util.List;

public interface AcademyService {
    Academy getById(Integer id);

    List<Academy> getAllAcademys();
}
