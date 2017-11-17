package ua.softserve.persistence.dao;


import ua.softserve.persistence.entity.Academy;

import java.util.List;

public interface AcademyDAO {
    Academy getById(Integer id);

    List<Academy> getAllAcademys();
}
