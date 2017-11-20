/*
* MainController
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import ua.softserve.persistence.dao.LanguageTranslationsDAO;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.AcademyService;
import ua.softserve.service.LanguageTranslationsService;
import ua.softserve.service.UserService;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class MainController {

    @Autowired
    AcademyService academyService;

    @Autowired
    LanguageTranslationsService languageTranslationsService;

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String init() {
        return "index";
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        List<User> allUsers = userService.findAll();
        model.addAttribute("allUsers", allUsers);
        return "showUsers";
    }

    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getAllAcademies(Model model) {
        List<Academy> list = academyService.getAllAcademys();
        model.addAttribute("listA", list.stream().limit(20).collect(Collectors.toList()));
        model.addAttribute("cities", languageTranslationsService.getTranslations());
        return "allAcademies";
    }
}
