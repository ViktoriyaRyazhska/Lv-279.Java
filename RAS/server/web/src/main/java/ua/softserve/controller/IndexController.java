/*
* IndexController
*
* Version 1.0-SNAPSHOT
*
* 27.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.controller;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController implements ErrorController {

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {

        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}