package ua.softserve.service.converter.impl;///*
//* AddGroupServiceImpl
//*
//* Version 1.0-SNAPSHOT
//*
//* 21.11.17
//*
//* All rights reserved by DoubleO Team (Team#1)
//* */
//
//package ua.softserve.service.converter.impl;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import ua.softserve.dto.AcademyDTO;
//import ua.softserve.persistence.entity.*;
//import ua.softserve.service.*;
//import ua.softserve.service.converter.AddGroupConverter;
//
//import java.util.List;
//
//@Service
//public class AddGroupConverterImpl implements AddGroupConverter{
//
//    @Autowired
//    AcademyService academyService;
//    @Autowired
//    AcademyStagesService academyStagesService;
//    @Autowired
//    DirectionService directionService;
//    @Autowired
//    TechnologieService technologieService;
//    @Autowired
//    ProfileService profileService;
//    @Autowired
//    LanguageTranslationsService languageTranslationsService;
//
//    @Override
//    public AcademyDTO loadDataToDTO() {
//        List<AcademyStages> academyStages = academyStagesService.getAllAcademyStagesService();
//        List<LanguageTranslations> cityNames = languageTranslationsService.getAllLanguageTranslationsName();
//        List<Directions> direction = directionService.findAll();
//        List<Technologies> technologie = technologieService.findAll();
//        List<Profile> profile = profileService.findAll();
//        return new AcademyDTO(academyStages, cityNames, direction, technologie, profile);
//    }
//}
