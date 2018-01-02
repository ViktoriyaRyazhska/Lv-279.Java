package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.persistence.entity.Academy;
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

    @GetMapping(value = "/group/{id}")
    public ResponseEntity<AcademyForSaveDTO> getAcademy(@PathVariable Integer id) {
        return new ResponseEntity<>(groupInfoService.getAcademyForSaveDTO(id), HttpStatus.OK);
    }

    @GetMapping(value = { "/group", "/getDropDownList" })
    public ResponseEntity<AcademyDropDownLists> getAllAcademies() {
        return new ResponseEntity<>(academyService.getAcademyDTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/group/add")
    public ResponseEntity saveGroup(@RequestBody AcademyForSaveDTO academyDTO) {
        academyService.saveAcademyAndGroupInfoFromAcademyDTO(academyDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/viewAcademies")
    public ResponseEntity<List<GroupInformationDTO>> searchSite() {
        return new ResponseEntity<>(groupInfoService.getAllInformationAboutGroup(), HttpStatus.OK);
    }
}
