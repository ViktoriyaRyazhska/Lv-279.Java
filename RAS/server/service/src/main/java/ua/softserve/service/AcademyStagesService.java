package ua.softserve.service;

import ua.softserve.persistence.entity.AcademyStages;

import java.util.List;

public interface AcademyStagesService {
    List<AcademyStages> getAllAcademyStagesService();

    void save(AcademyStages academyStages);

    AcademyStages findOne(int id);

    void remove(AcademyStages academyStages);
}
