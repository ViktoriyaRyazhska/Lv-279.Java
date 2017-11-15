package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.softserve.data.entity.User;
import ua.softserve.service.UserService;

import java.util.List;

@RestController
public class MyRESTController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public List<User> searchproduct (){
        return userService.findAll();
    }
    @GetMapping("find-{id}")
    public User getUserById(@PathVariable int id){
        return userService.findUserById(id);
    }
    @GetMapping("save-{firstname}")
    public void saveUserById(@PathVariable String firstname){
        userService.save(new User(firstname));
    }
}
