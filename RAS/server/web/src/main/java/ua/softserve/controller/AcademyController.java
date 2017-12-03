package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.*;
import ua.softserve.service.dto.DropBoxForAcademyDTO;

import javax.accessibility.AccessibleValue;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static java.util.Arrays.asList;

@Controller
public class AcademyController {
    @Autowired
    AcademyService academyService;

    @Autowired
    DropBoxForAcademyDTOService dropBoxForAcademyDTOService;

    @RequestMapping(value = "/academy/{academyId}",method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<Academy> getAcademy(@PathVariable Integer academyId) {
        return new ResponseEntity<Academy>(academyService.getById(academyId), HttpStatus.OK);
    }

    @RequestMapping(value = "/academy/addgroup",method = RequestMethod.GET, produces = {"application/json"})
    public ResponseEntity<DropBoxForAcademyDTO> getAllAcademys() {
        return new ResponseEntity<DropBoxForAcademyDTO>(dropBoxForAcademyDTOService.getDropBox(), HttpStatus.OK);
    }

    @RequestMapping(value = "/viewAcademies",method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody
    List<AcademyDTO> searchSite(HttpServletRequest request) {
        List<AcademyDTO> academyDTOS = academyService.findWithEmployeeExperts();
        return academyDTOS;
    }

}

