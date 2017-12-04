//package ua.softserve.controller;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//import ua.softserve.persistence.entity.LanguageTranslations;
//import ua.softserve.service.ItaTacticalPlanByGroupStageDtoService;
//import ua.softserve.service.dto.ItaTacticalPlanByGroupStageDto;
//
//import java.util.List;
//
//@RestController
//public class ItaTacticalPlanByGroupStageController {
//    @Autowired
//    ItaTacticalPlanByGroupStageDtoService itaTacticalPlanByGroupStageDtoService;
//
//    @RequestMapping(value = "/tacticalReport",method = RequestMethod.GET, produces = {"application/json"})
//    public ResponseEntity<List<ItaTacticalPlanByGroupStageDto>> getCity() {
//        return new ResponseEntity<>(itaTacticalPlanByGroupStageDtoService.findAll(), HttpStatus.OK);
//    }
//
//}
