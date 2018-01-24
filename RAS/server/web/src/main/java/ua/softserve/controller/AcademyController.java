package ua.softserve.controller;

import com.sun.org.apache.regexp.internal.RE;
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
        return new ResponseEntity<>(groupInfoService.getAcademyDTObyId(id), HttpStatus.OK);
    }

    @GetMapping(value = { "/dropdown", "/get-dropdown-list" })
    public ResponseEntity<AcademyDropDownLists> getDropdownList() {
        return new ResponseEntity<>(academyService.getAcademyDTO(), HttpStatus.OK);
    }

    @GetMapping(value = "/get-group-overview-dropdown")
    public ResponseEntity<GroupOverviewDropDownLists> getDropdownLists(){
        return new ResponseEntity<>(academyService.getGroupOverviewDTO(), HttpStatus.OK);
    }

    @PostMapping(value = "/group/add")
    public ResponseEntity saveGroup(@RequestBody AcademyDTO academyDTO) {
        academyService.saveAcademyAndGroupInfoFromAcademyDTO(academyDTO);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/view-groupinfo")
    public ResponseEntity<List<GroupInformationDTO>> searchSite() {
        long startTime = System.currentTimeMillis();
        List<GroupInformationDTO> informationAboutGroup = groupInfoService.getAllInformationAboutGroup();
        long endTime = System.currentTimeMillis();
        logger.info("Time for executing method in the controller : " + (float)(endTime - startTime)/1000);
        return new ResponseEntity<>(informationAboutGroup, HttpStatus.OK);
    }
}
