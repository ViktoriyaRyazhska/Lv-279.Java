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

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/main")
    public String welcome() {
        return "forward:/index.html";
    }

    @GetMapping("/")
    public String init() {
        return "redirect:/main";
    }
}
