package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.User;
import ua.softserve.service.UserService;
import ua.softserve.service.dto.UserShortViewDto;
import ua.softserve.util.NumberUtils;

import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * Gets from DB list of all users.
     *
     * @return JSON object of list of all users from DB.
     */
    @GetMapping(value = "/user/getAllUsers", produces = { "application/json" })
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}/users", produces = { "application/json" })
    public List<UserShortViewDto> getStudentsByAcademy(@PathVariable("id") Integer academyId) {
        return userService.getAllUsersByAcademy(academyId);
    }

    @GetMapping("user")
    public Page<UserShortViewDto> findByIdAndName(@RequestParam(value = "id", required = false) String id,
            @RequestParam("page") Integer pageNum, @RequestParam("size") Integer size,
            @RequestParam("notInAcademy") Integer notInAcademy,
            @RequestParam(value = "dir", required = false) String dir) {

        if (!StringUtils.isEmpty(id) && !NumberUtils.isNumber(id)) {
            throw new IllegalArgumentException("Id must be numeric");
        }

        return userService.findPageById(notInAcademy, id, pageNum, size, dir);
    }
}
