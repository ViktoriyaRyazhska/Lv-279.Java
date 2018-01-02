package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.softserve.service.UserService;
import ua.softserve.service.dto.UserShortViewDto;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("users/{id}")
    public List<UserShortViewDto> getUsersByAcademyAndStatus(@PathVariable("id") Integer academyId) {
        return userService.getAllUsersByAcademyAndStatus(academyId);
    }
}
