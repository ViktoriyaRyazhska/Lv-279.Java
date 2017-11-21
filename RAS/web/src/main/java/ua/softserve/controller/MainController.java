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
import ua.softserve.persistence.entity.User;
import ua.softserve.service.UserService;

import java.util.List;

@Controller
public class MainController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String init() {
        return "index";
    }

    @GetMapping("/showUsers")
    public String showUsers(Model model) {
        List<User> allUsers = userService.findAll();
        for (User user:allUsers) {
            System.out.println(user.getFirstName());
        }
        model.addAttribute("allUsers", allUsers);
        return "showUsers";
    }
}
