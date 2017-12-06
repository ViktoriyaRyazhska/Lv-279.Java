package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.repo.AcademyStagesRepository;
import ua.softserve.persistence.entity.AcademyStages;
import ua.softserve.service.AcademyStagesService;

import java.util.List;

@Service
public class AcademyStagesServiceimpl implements AcademyStagesService {
    @Autowired
    private AcademyStagesRepository academyRepository;

    @Transactional(readOnly = true)
    @Override
    public List<AcademyStages> getAllAcademyStagesService() {
        return academyRepository.findAll();
    }

    @Override
    public void save(AcademyStages academyStages) {
        academyRepository.save(academyStages);
    }

    @Override
    public AcademyStages findOne(int id) {
        return academyRepository.findOne(id);
    }

    @Override
    public void remove(AcademyStages academyStages) {
        academyRepository.delete(academyStages);
    }
}
