package ua.softserve.controller;


import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class AcademyController {
    @Autowired
    GroupRepo groupRepo;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<GroupInfo> getAcademy() {
        return new ResponseEntity<>(
                groupRepo.findByAcademy_AcademyId(5),
                HttpStatus.OK);
    }
}

