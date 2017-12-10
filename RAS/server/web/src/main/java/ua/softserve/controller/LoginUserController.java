package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.Authority;
import ua.softserve.persistence.entity.LoginUser;
import ua.softserve.service.impl.LoginUserServiceImpl;

@RestController
public class LoginUserController {
    @Autowired
    LoginUserServiceImpl userService;

    // @GetMapping("/")
    // public String init(){
    // return "index";
    // }

//    @GetMapping("/registr/{username}/{password}")
//    public void registration(@PathVariable String username, @PathVariable String password) {
//        LoginUser user = new LoginUser();
//        user.setUsername(username);
//        user.setPassword(password);
////        user.setAuthority(Authority.ADMIN);
//        userService.save(user);
//    }

    @GetMapping("/success")
    public String success() {
        return "success";
    }

    @GetMapping("/fail")
    public String fail() {
        return "fail";
    }
}
