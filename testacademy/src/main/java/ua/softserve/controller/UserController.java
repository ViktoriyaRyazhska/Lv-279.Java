package ua.softserve.controller;


import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.entity.User;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.service.UserService;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService uServ;

    /**
     *
     * Demo controller for saving n random users
     * @param count (n) number of users to generating and saving
     * @return simple string 'Hello'
     */
    @GetMapping(value = "/user/randomAdd{count}", produces = {"application/json"})
    public ResponseEntity<String> randomAddUsers(@PathVariable int count) {
        uServ.genAndSaveUsers(count);
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    /**
     * Gets from DB list of all users.
     * @return JSON object of list of all users from DB.
     */
    @GetMapping(value = "/user/getAllUsers", produces = {"application/json"})
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(uServ.findAll(), HttpStatus.OK);
    }
}

