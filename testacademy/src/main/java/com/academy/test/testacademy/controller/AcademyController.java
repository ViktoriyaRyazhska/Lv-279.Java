package com.academy.test.testacademy.controller;


import com.academy.test.testacademy.entity.GroupInfo;
import com.academy.test.testacademy.repo.GroupRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
public class AcademyController {
    @Autowired
    GroupRepo groupRepo;

    @RequestMapping(value = "/",method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<GroupInfo> getAcademy() {
        return new ResponseEntity<GroupInfo>(groupRepo.findByAcademy_AcademyId(5), HttpStatus.OK);
    }
}

