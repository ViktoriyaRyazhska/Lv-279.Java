package ua.softserve.repository.dao;

import ua.softserve.data.entity.Academy;

import java.util.List;

public interface AcademyDAO {
    Academy getById(Integer id);

    List<Academy> getAllAcademys();
}
