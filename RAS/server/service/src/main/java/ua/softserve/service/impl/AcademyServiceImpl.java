package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.AcademyConverter;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.dto.AcademyForSaveDTO;

import java.util.List;

@Service
public class AcademyServiceImpl implements AcademyService {
    @Autowired
    AcademyRepository academyRepository;

    @Autowired
    AcademyStagesService academyStagesService;

    @Autowired
    DirectionService directionService;

    @Autowired
    TechnologyServiceImpl technologyServiceImpl;

    @Autowired
    ProfileService profileService;

    @Autowired
    LanguageTranslationsService languageTranslationsService;

    @Autowired
    GroupInfoService groupInfoService;

    @Autowired
    private AcademyConverter academyConverter;

    @Transactional(readOnly = true)
    @Override
    public Academy getById(Integer id) {
        return academyRepository.findOne(id);
    }

    @Transactional
    @Override
    public Integer save(Academy academy) {
        return academyRepository.save(academy).getAcademyId();
    }

    @Transactional
    @Override
    public void saveAcademyFromAcademyDTO(AcademyForSaveDTO academyDTO) {
        Academy academy = academyConverter.toEntity(academyDTO);
        System.out.println(academy.getStartDate());
        int academyId = save(academy);

        saveGroupInfo(academyId, academyDTO);
    }

    private void saveGroupInfo(int academyId, AcademyForSaveDTO academyDTO) {
        GroupInfo groupInfo = academyConverter.groupInfoToEntity(academyId, academyDTO);
        groupInfoService.save(groupInfo);
    }

    @Transactional
    @Override
    public Academy findOne(int id) {
        return academyRepository.findOne(id);
    }

    @Transactional
    @Override
    public AcademyForSaveDTO getAcademyDTO() {
        AcademyForSaveDTO academyDTO = new AcademyForSaveDTO();
        academyDTO.setAcademyStages(academyStagesService.getAllAcademyStagesService());
        academyDTO.setDirection(directionService.findAllDirectionsInIta());
        academyDTO.setTechnologie(technologyServiceImpl.findAllTechonologyInIta());
        academyDTO.setProfile(profileService.findAll());
        academyDTO.setCityNames(languageTranslationsService.getAllLanguageTranslationsName());
        return academyDTO;
    }

    @Transactional
    @Override
    public List<Academy> getAllAcademies() {
        return academyRepository.findAll();
    }

}
