/*
 * RoutingController
 *
 * Version 1.0-SNAPSHOT
 *
 * 06.12.17
 *
 * All rights reserved by DoubleO Team (Team#1)
 * */

package ua.softserve.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RoutingController {

    @RequestMapping({"/main"})
    public String index() {
        return "forward:/index.html";
    }

}
