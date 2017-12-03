package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.softserve.service.*;
import ua.softserve.service.dto.DropBoxForAcademyDTO;

@Service
public class DropBoxForAcademyDTOServiceImpl implements DropBoxForAcademyDTOService {
    @Autowired
    AcademyStagesService academyStagesService;

    @Autowired
    DirectionService directionService;

    @Autowired
    TechnologieService technologieService;

    @Autowired
    ProfileService profileService;

    @Autowired
    LanguageTranslationsService languageTranslationsService;

    @Override
    public DropBoxForAcademyDTO getDropBox(){
        DropBoxForAcademyDTO dropBoxForAcademyDTO = new DropBoxForAcademyDTO();
        dropBoxForAcademyDTO.setAcademyStages(academyStagesService.getAllAcademyStagesService());
        dropBoxForAcademyDTO.setDirection(directionService.findAllDirectionsInIta());
        dropBoxForAcademyDTO.setTechnologie(technologieService.findAllTechonologyInIta());
        dropBoxForAcademyDTO.setProfile(profileService.findAll());
        dropBoxForAcademyDTO.setCityNames(languageTranslationsService.getAllLanguageTranslationsName());
        return dropBoxForAcademyDTO;
    }
}
