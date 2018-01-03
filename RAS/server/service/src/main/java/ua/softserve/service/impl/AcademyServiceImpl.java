package ua.softserve.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.*;
import ua.softserve.persistence.repo.AcademyRepository;
import ua.softserve.service.*;
import ua.softserve.service.converter.GroupInfoConverter;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.dto.AcademyDropDownLists;
import ua.softserve.validator.GroupValidator;

import java.sql.Date;
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

    @Autowired
    GroupInfoService groupInfoService;

    @Autowired
    GroupValidator groupValidator;

    @Autowired
    HistoryService historyService;

    @Autowired
    AcademyService academyService;


    @Autowired
    CityService cityService;


    @Autowired
    TechnologyService technologyService;

    @Autowired
    StudentService studentService;

    @Transactional
    @Override
    public Integer save(Academy academy) {
        return academyRepository.save(academy).getAcademyId();
    }

    /**
     * Method saves academy than saves group info
     *
     * @param academyDTO
     */
    @Transactional
    @Override
    public void saveAcademyAndGroupInfoFromAcademyDTO(AcademyDTO academyDTO) {
        groupValidator.validate(academyDTO);

        Academy academy;

        if (academyDTO.getAcademyId() == 0) {
            academy = new Academy();
        } else {
            academy = academyService.findOne(academyDTO.getAcademyId());
        }

        academy.setName(academyDTO.getNameForSite());
        academy.setAcademyStages(getAcademyStages(academyDTO.getAcademyStagesId()));
        academy.setStartDate(convertLongToDate(academyDTO.getStartDate()));
        academy.setEndDate(convertLongToDate(academyDTO.getEndDate()));
        academy.setCity(getCity(academyDTO.getCityId()));
        academy.setFree(academyDTO.getPayment());
        academy.setDirections(getDirection(academyDTO.getDirectionId()));
        academy.setTechnologies(getTechnologies(academyDTO.getTechnologieId()));

        int academyId = save(academy);

        GroupInfo groupInfo;

        if (academyDTO.getGroupInfoId() == 0) {
            groupInfo = new GroupInfo();
        } else {
            groupInfo = groupInfoService.findOneGroupInfoByAcademyId(academyDTO.getAcademyId());
        }

        groupInfo.setAcademy(getAcademyById(academyId));
        groupInfo.setGroupName(academyDTO.getGrName());
        groupInfo.setProfileInfo(getProfileInfo(academyDTO.getProfileId()));
        groupInfo.setStudentsPlannedToEnrollment(academyDTO.getStudentPlannedToEnrollment());
        groupInfo.setStudentsPlannedToGraduate(academyDTO.getStudentPlannedToGraduate());

        groupInfoService.save(groupInfo);

        historyService.saveModifyby(academyId);
    }

    /**
     * Method return Academy by id
     *
     * @param id
     * @return Academy
     */
    @Transactional
    @Override
    public Academy findOne(int id) {
        logger.info("Before academyRepository.findOne(id)");

        Academy findGroup = academyRepository.findOne(id);
        if (findGroup == null) {
            logger.error("Group with id " + id + " not found");
            throw new NoSuchElementException("Group with id " + id + " not found");
        }
        return findGroup;
    }

    /**
     * Method combines information for dropdown lists on the UI to DTO.
     *
     * @return DTO that contains information for dropdown lists.
     */
    @Transactional
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

    /**
     * Method return list of all Academy
     *
     * @return list of all Academy
     */
    @Transactional
    @Override
    public List<Academy> getAllAcademies() {
        return academyRepository.findAll();
    }

    private Academy getAcademyById(int academyId) {
        return academyService.findOne(academyId);
    }

    private ProfileInfo getProfileInfo(int profileInfoId) {
        return profileService.findOne(profileInfoId);
    }

    private Date convertLongToDate(Long dateMilliseconds) {
        return new Date(dateMilliseconds);
    }

    private City getCity(int id) {
        return cityService.findOne(id);
    }

    private AcademyStages getAcademyStages(int academyStagesId) {
        return academyStagesService.findOne(academyStagesId);
    }

    private Directions getDirection(int direcrionId) {
        return directionService.findOne(direcrionId);
    }

    private Technologies getTechnologies(int technologieId) {
        return technologyService.findOne(technologieId);
    }
}
