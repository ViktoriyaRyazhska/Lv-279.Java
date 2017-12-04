package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.LanguageTranslations;
import ua.softserve.service.*;

import java.util.List;

@RestController
public class TestController {
    @Autowired
    AcademyService academyService;

    @Autowired
    LanguageTranslationsService languageTranslationsService;

    @Autowired
    DirectionService directionService;

    @Autowired
    TechnologyService technologyService;

    @RequestMapping(value = "/test",method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<List<LanguageTranslations>> getCity() {
        return new ResponseEntity<>(languageTranslationsService.getAllLanguageTranslationsName(), HttpStatus.OK);
    }
}
