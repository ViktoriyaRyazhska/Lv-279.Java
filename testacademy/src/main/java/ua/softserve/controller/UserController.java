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

    @GetMapping(value = "/user/randomAdd{count}", produces = {"application/json"})
    public ResponseEntity<String> randomAddUsers(@PathVariable int count) {
        uServ.genAndSaveUsers(count);
        return new ResponseEntity<>("Hello", HttpStatus.OK);
    }

    @GetMapping(value = "/user/getAllUsers", produces = {"application/json"})
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(uServ.findAll(), HttpStatus.OK);
    }
}

