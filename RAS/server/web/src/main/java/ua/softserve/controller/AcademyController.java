package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.Academy;
import ua.softserve.persistence.repo.GroupInfoRepository;
import ua.softserve.service.AcademyService;
import ua.softserve.service.GroupInfoService;
import ua.softserve.service.dto.*;

import java.util.List;

@RestController
public class AcademyController {
    @Autowired
    AcademyService academyService;

    @Autowired
    GroupInfoService groupInfoService;

    @Autowired
    GroupInfoRepository groupInfoRepository;

    @RequestMapping(value = "/academy/{academyId}", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<Academy> getAcademy(@PathVariable Integer academyId) {
        return new ResponseEntity<>(academyService.findOne(academyId), HttpStatus.OK);
    }

    @RequestMapping(value = {"/academy/addgroup", "/getDropDownList"}, method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<AcademyDropDownLists> getAllAcademies() {
        return new ResponseEntity<>(academyService.getAcademyDTO(), HttpStatus.OK);
    }

    @RequestMapping(value = "/academy/addgroup", method = RequestMethod.POST, produces = { "application/json" })
    public void saveGroup(@RequestBody AcademyForSaveDTO academyDTO) {
        academyService.saveAcademyFromAcademyDTO(academyDTO);
    }

    @GetMapping(value = "/viewAcademies")
    public ResponseEntity<List<AcademyForViewDTO>> searchSite() {
        groupInfoRepository.findAll();
        groupInfoService.getAllInfo();
        return new ResponseEntity<>(groupInfoService.getAllAcademies(), HttpStatus.OK);
    }
}
