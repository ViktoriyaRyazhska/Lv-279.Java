package ua.softserve.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AcademyController {
    @Autowired
    AcademyService academyService;

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

//    @RequestMapping(value = "/academy/{academyId}",method = RequestMethod.GET, produces = {"application/json"})
//    public ResponseEntity<Academy> getAcademy(@PathVariable Integer academyId) {
//        return new ResponseEntity<Academy>(academyService.getById(academyId), HttpStatus.OK);
//    }

    @RequestMapping(value = "/academy/{academyId}",method = RequestMethod.GET, produces = {"application/json"})
    public String getAcademy(@PathVariable Integer academyId) {
        return academyService.getById(academyId).toString();
    }


    @RequestMapping(value = "/searchSite",method = RequestMethod.POST, produces = {"application/json"})
    public List<Academy> searchSite(HttpServletRequest request) {
        List<Academy> list = academyService.findAllByName(request.getParameter("searchPhrase"));
        return list;
    }


    @RequestMapping(value = "/group",method = RequestMethod.GET)
    public String getAllStatuses(Model model) {
        List<AcademyStages> academyStages = academyStagesService.getAllAcademyStagesService();
        List<LanguageTranslations> cityNames = languageTranslationsService.getAllLanguageTranslationsName();
        List<Directions> direction = directionService.findAll();
        List<Technologies> technologie = technologieService.findAll();
        List<Profile> profile = profileService.findAll();


        model.addAttribute("academyStages", academyStages);
        model.addAttribute("cityNames", cityNames);
        model.addAttribute("direction", direction);
        model.addAttribute("technologie", technologie);
        model.addAttribute("profile", profile);
        return "group";
    }
}

