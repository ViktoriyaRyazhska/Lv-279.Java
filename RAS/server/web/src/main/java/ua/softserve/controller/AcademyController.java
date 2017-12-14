package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.service.AcademyService;
import ua.softserve.service.GroupInfoService;
import ua.softserve.service.dto.AcademyDTO;
import ua.softserve.service.dto.AcademyForSaveDTO;
import ua.softserve.service.dto.AcademyForViewDTO;

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
    public ResponseEntity<AcademyForSaveDTO> getAllAcademies() {
        return new ResponseEntity<>(academyService.getAcademyDTO(), HttpStatus.OK);
    }

    @RequestMapping(value = "/academy/addgroup", method = RequestMethod.POST, produces = { "application/json" })
    public void saveGroup(@RequestBody AcademyForSaveDTO academyDTO) {
        academyService.saveAcademyFromAcademyDTO(academyDTO);
    }

    @RequestMapping(value = "/viewAcademies", method = RequestMethod.GET)
    public ResponseEntity<List<AcademyForViewDTO>> searchSite() {
        return new ResponseEntity<>(groupInfoService.getAllAcademies(), HttpStatus.OK);
    }
}
