/*
* MyRestController
*
* Version 1.0-SNAPSHOT
*
* 27.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class MyRestController {

    @GetMapping("/api/hi")
    public String hi() {
        System.out.println("rest");
        int i = new Random().nextInt(100);
        return "Hello World from Restful API: " + i;
    }

}
