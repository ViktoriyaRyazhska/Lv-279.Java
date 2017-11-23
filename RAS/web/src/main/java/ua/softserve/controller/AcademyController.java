package ua.softserve.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.dto.AcademyDTO;
import ua.softserve.persistence.dto.LanguageTranslationDTO;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.*;
import ua.softserve.service.editor.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

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
    StudentGroupCountService studentGroupCountService;

    @Autowired
    LanguageTranslationsService languageTranslationsService;

    @Autowired
    LanguageTranslationDTO languageTranslationDTO;

    @Autowired
    AcademyStagesEditor academyStagesEditor;

    @Autowired
    CityEditor cityEditor;

    @Autowired
    DirectionEditor directionEditor;

    @Autowired
    ProfileEditor profileEditor;

    @Autowired
    StudentGroupCountEditor studentGroupCountEditor;

    @Autowired
    TechnologieEditor technologieEditor;


    @InitBinder("academyDTO")
    public void binder(WebDataBinder binder) {
        binder.registerCustomEditor(AcademyStages.class,"academyStages", academyStagesEditor);
        binder.registerCustomEditor(Directions.class,"direction", directionEditor);
        binder.registerCustomEditor(LanguageTranslations.class,"cityNames", cityEditor);
        binder.registerCustomEditor(Profile.class,"profile", profileEditor);
        binder.registerCustomEditor(StudentGroupCount.class,"studentGroupCount", studentGroupCountEditor);
        binder.registerCustomEditor(Technologies.class,"technologie", technologieEditor);
    }

//    @RequestMapping(value = "/academy/{academyId}",method = RequestMethod.GET, produces = {"application/json"})
//    public ResponseEntity<Academy> getAcademy(@PathVariable Integer academyId) {
//        return new ResponseEntity<Academy>(academyService.getById(academyId), HttpStatus.OK);
//    }

//    @RequestMapping(value = "/academy/{academyId}",method = RequestMethod.GET, produces = {"application/json"})
//    public String getAcademy(@PathVariable Integer academyId) {
//        return academyService.getById(academyId).toString();
//    }
//
//



    @RequestMapping(value = "/group", method = RequestMethod.GET)
    public String showModel(Model model) {
        model.addAttribute("academyDTO", new AcademyDTO());

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
        model.addAttribute("studentGroupCount", new StudentGroupCount());
        return "addGroup";
    }

    @PostMapping("/group/addGroup")
    public String addGroup(@ModelAttribute AcademyDTO academyDTO) {

        System.out.println(academyDTO);

        academyService.saveDTO(academyDTO);

        return "index";
    }


    @RequestMapping(value = "/allGroupsInf",method = RequestMethod.GET)
    public String getAllAcademies(Model model) {
        List<Academy> academies = academyService.findWithEmployeeExperts();
        Collections.reverse(academies);
        model.addAttribute("academies", academies.stream().limit(20).collect(Collectors.toList()));

        List<LanguageTranslations> translations = languageTranslationsService.getAllLanguageTranslationsName();
        HashMap<Integer, String> cityHashMap = languageTranslationDTO.convertListToHashMap(translations);
        model.addAttribute("cities", cityHashMap);


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
        model.addAttribute("studentGroupCount", new StudentGroupCount());
        return "allAcademies";
    }



}

