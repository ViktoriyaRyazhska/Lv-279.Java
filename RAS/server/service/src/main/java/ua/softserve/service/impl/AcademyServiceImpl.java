package ua.softserve.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.GroupInfoConverter;
import ua.softserve.service.dto.AcademyDropDownLists;
import ua.softserve.service.dto.AcademyForSaveDTO;
import ua.softserve.service.exception.InvalidDataException;
import ua.softserve.service.exception.InvalidTimeFrameException;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AcademyServiceImpl implements AcademyService {
    private final Logger logger = LoggerFactory.getLogger(AcademyServiceImpl.class.getName());

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
    GroupInfoConverter groupInfoConverter;

    @Transactional
    @Override
    public Integer save(Academy academy) {
        return academyRepository.save(academy).getAcademyId();
    }

    private <T> void checkingForNotNullAndNotEmpty(String fieldName, T t) {
        if (t == null) {
            logger.error(fieldName + " can't be null");
            throw new InvalidDataException(fieldName + " can't be null");
        } else if (t instanceof String) {
            if (((String) t).isEmpty()) {
                logger.error(fieldName + " can't be empty");
                throw new InvalidDataException(fieldName + " can't be empty");
            }
        }
    }

    private void checkingIfEndDateBiggestThanStartDate(Long startDate, Long endDate) {
        if (startDate > endDate) {
            logger.error("End date can't be biggest than start date");
            throw new InvalidTimeFrameException("End date can't be biggest than start date");
        }
    }

    private boolean isAcademyDTOisValid(AcademyForSaveDTO academyDTO) {
        checkingForNotNullAndNotEmpty("Group Name", academyDTO.getGrName());
        checkingForNotNullAndNotEmpty("Name for Site", academyDTO.getNameForSite());

        checkingForNotNullAndNotEmpty("Stard Date", academyDTO.getStartDate());
        checkingForNotNullAndNotEmpty("End Date", academyDTO.getEndDate());
        checkingIfEndDateBiggestThanStartDate(academyDTO.getStartDate(), academyDTO.getEndDate());

        return true;
    }


//    @Transactional
//    @Override
//    public void saveAcademyAndGroupInfoFromAcademyDTO(AcademyForSaveDTO academyDTO) {
//        if(isAcademyDTOisValid(academyDTO)) {
//            Academy academy = academyConverter.toEntity(academyDTO);
//            int academyId = save(academy);
//
//            GroupInfo groupInfo = groupInfoConverter.toEntity(academyId, academyDTO);
//            groupInfoService.save(groupInfo);
//        }
//    }

    @Override
    public Academy findOne(int id) {
        logger.info("Before academyRepository.findOne(id)");

        Academy findGroup = academyRepository.findOne(id);
        if (findGroup == null) {
            logger.error("Group with id "+id+" not found");
            throw new NoSuchElementException("Group with id "+id+" not found");
        }
        return findGroup;
    }

    /**
     * Method combines information for dropdown lists on the UI to DTO.
     *
     * @return DTO that contains information for dropdown lists.
     */
    @Override
    public AcademyDropDownLists getAcademyDTO() {
        AcademyDropDownLists academyDropDownLists = new AcademyDropDownLists();
        academyDropDownLists.setAcademyStages(academyStagesService.getAllAcademyStagesService());
        academyDropDownLists.setDirection(directionService.findAllDirectionsInIta());
        academyDropDownLists.setTechnologie(technologyServiceImpl.findAllTechonologyInIta());
        academyDropDownLists.setProfile(profileService.findAll());
        academyDropDownLists.setCityNames(languageTranslationsService.getAllLanguageTranslationsName());
        return academyDropDownLists;
    }

    @Override
    public List<Academy> getAllAcademies() {
        return academyRepository.findAll();
    }
}
