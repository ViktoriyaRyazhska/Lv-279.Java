package ua.softserve.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.dto.GroupInformationDTO;
import ua.softserve.service.AcademyService;
import ua.softserve.service.GroupInfoService;
import ua.softserve.service.dto.*;
import ua.softserve.service.impl.AcademyServiceImpl;

import java.util.List;

@RestController
public class AcademyController {
    private final Logger logger = LoggerFactory.getLogger(AcademyController.class.getName());

    @Autowired
    AcademyService academyService;

    @Autowired
    GroupInfoService groupInfoService;

    @GetMapping(value = "/group/{id}")
    public ResponseEntity<AcademyDTO> getAcademyDTObyId(@PathVariable Integer id) {
        logger.info("Before groupInfoService.getAcademyDTObyId("+id+")");
        return new ResponseEntity<>(groupInfoService.getAcademyDTObyId(id), HttpStatus.OK);
    }

    @GetMapping(value = { "/dropdown", "/getDropDownList" })
    public ResponseEntity<AcademyDropDownLists> getDropdownList() {
        logger.info("Before academyService.getAcademyDTO()");
        return new ResponseEntity<>(academyService.getAcademyDTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/group/add")
    public ResponseEntity saveGroup(@RequestBody AcademyDTO academyDTO) {
        logger.info("Before academyService.saveAcademyAndGroupInfoFromAcademyDTO(academyDTO)");
        academyService.saveAcademyAndGroupInfoFromAcademyDTO(academyDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/viewAcademies")
    public ResponseEntity<List<GroupInformationDTO>> searchSite() {
        return new ResponseEntity<>(groupInfoService.getAllInformationAboutGroup(), HttpStatus.OK);
    }
}
