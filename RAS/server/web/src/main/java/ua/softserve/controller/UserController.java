package ua.softserve.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.service.UserService;
import ua.softserve.service.dto.UserShortViewDto;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class.getName());

    @Autowired
    private UserService userService;

    @GetMapping("users/{id}")
    public ResponseEntity getUsersByAcademyAndStatus(@PathVariable("id") Integer academyId) {
        try {
            logger.info("Get user from group with id: " + academyId);
            return new ResponseEntity<List<UserShortViewDto>>(
                    userService.getAllUsersByAcademyAndStatus(academyId), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Group with id " + academyId + " not found");
        }
    }
}
