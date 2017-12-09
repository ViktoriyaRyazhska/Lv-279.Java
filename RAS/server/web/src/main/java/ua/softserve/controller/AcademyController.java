package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.service.converter.AcademyConverter;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.persistence.entity.*;
import ua.softserve.service.*;

import java.util.List;

@RestController
public class AcademyController {
    @Autowired
    AcademyService academyService;

    @Autowired
    GroupInfoService groupInfoService;

    @RequestMapping(value = "/academy/{academyId}", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<Academy> getAcademy(@PathVariable Integer academyId) {
        return new ResponseEntity<Academy>(academyService.getById(academyId), HttpStatus.OK);
    }

    @RequestMapping(value = "/academy/addgroup", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<AcademyDTO> getAllAcademies() {
        return new ResponseEntity<AcademyDTO>(academyService.getAcademyDTO(), HttpStatus.OK);
    }

    @RequestMapping(value = "/academy/addgroup", method = RequestMethod.POST, produces = { "application/json" })
    public void saveGroup(@RequestBody AcademyDTO academyDTO) {
        System.out.println(academyDTO);
//        academyService.save(academyDTO);
    }

    @RequestMapping(value = "/viewAcademies", method = RequestMethod.GET)
    @CrossOrigin(origins = "http://localhost:4200")
    public @ResponseBody List<AcademyDTO> searchSite() {
        List<AcademyDTO> academyDTOS = groupInfoService.getAllAcademies();
        return academyDTOS;
    }
}
