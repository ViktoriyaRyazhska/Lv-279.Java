package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.AcademyConverter;
import ua.softserve.service.converter.GroupInfoConverter;
import ua.softserve.service.dto.AcademyForSaveDTO;

import java.util.List;
import java.util.TreeMap;

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
    AcademyConverter academyConverter;

    @Autowired
    GroupInfoConverter groupInfoConverter;

    @Transactional
    @Override
    public Integer save(Academy academy) {
        return academyRepository.save(academy).getAcademyId();
    }

    @Transactional
    @Override
    public void saveAcademyFromAcademyDTO(AcademyForSaveDTO academyDTO) {
        Academy academy = academyConverter.toEntity(academyDTO);

        int academyId = save(academy);

        saveGroupInfo(academyId, academyDTO);
    }

    @Transactional
    public void saveGroupInfo(int academyId, AcademyForSaveDTO academyDTO) {
        GroupInfo groupInfo = groupInfoConverter.toEntity(academyId, academyDTO);
        groupInfoService.save(groupInfo);
    }

    @Override
    public Academy findOne(int id) {
        return academyRepository.findOne(id);
    }

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

    @Override
    public List<Academy> getAllAcademies() {
        return academyRepository.findAll();
    }
}
