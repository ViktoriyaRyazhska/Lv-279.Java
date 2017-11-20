package ua.softserve.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.service.AcademyService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class AcademyController {
    @Autowired
    AcademyService academyService;

//    @RequestMapping(value = "/academy/{academyId}",method = RequestMethod.GET, produces = {"application/json"})
//    public ResponseEntity<Academy> getAcademy(@PathVariable Integer academyId) {
//        return new ResponseEntity<Academy>(academyService.getById(academyId), HttpStatus.OK);
//    }

    @RequestMapping(value = "/academy/{academyId}",method = RequestMethod.GET, produces = {"application/json"})
    public String getAcademy(@PathVariable Integer academyId) {
        return academyService.getById(academyId).toString();
    }


    @RequestMapping(value = "/searchSite",method = RequestMethod.POST, produces = {"application/json"})
    public List<Academy> searchSite(HttpServletRequest request) {
        List<Academy> list = academyService.findAllByName(request.getParameter("searchPhrase"));
        return list;
    }
}

