//package ua.softserve.controller;
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//import ua.softserve.persistence.entity.ItaAcademy;
//import ua.softserve.persistence.entity.User;
//import ua.softserve.service.ItaAcademyService;
//
//import java.util.LinkedList;
//import java.util.List;
//
//
//@Controller
//public class ItaAcademyController {
//
//    @Autowired
//   private ItaAcademyService itaAcademyService;
//
////    @GetMapping("/users/{id}")
////    public String showUsers(@PathVariable("id") Integer academyId,Model model) {
////        List<User> allUsers = itaAcademyService.getAllUsersOfAcademy(academyId);
////        model.addAttribute("allUsers", allUsers);
////        return "showUsers";
////    }
////
////
////    @GetMapping("/showItaAcademy/{id}")
////    public String showItaAcademy(@PathVariable("id") Integer academyId, Model model) {
////        List<ItaAcademy> list = itaAcademyService.getAllItaAcademyByAcademy(academyId);
////        model.addAttribute("list", list);
////        return "showItaAcademyById";
////    }
////
////
////
////    @GetMapping("/showItaAcademyById")
////    public String showItaAcademyById(Model model) {
////        ItaAcademy itaAcademy = itaAcademyService.getItaAcademyById(22198);
////        List<ItaAcademy> list = new LinkedList<ItaAcademy>(){};
////        list.add(itaAcademy);
////        model.addAttribute("list", list);
////        return "showItaAcademyById";
////    }
////
////
////
////    @GetMapping("{id}")
////    public ResponseEntity<ItaAcademy> getItaAcademyById(@PathVariable("id") int id) {
////        ItaAcademy itaAcademy = itaAcademyService.getItaAcademyById(id);
////        if (itaAcademy == null) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        } else {
////            return new ResponseEntity<>(itaAcademy, HttpStatus.OK);
////        }
////    }
////
////    @GetMapping("{id}")
////    public ResponseEntity<Integer> getUserId(@PathVariable("id") int id) {
////        ItaAcademy itaAcademy = itaAcademyService.getItaAcademyById(id);
////        if (itaAcademy == null) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        } else {
////            return new ResponseEntity<>(itaAcademy.getUser().getId(), HttpStatus.OK);
////        }
////    }
////
////    @GetMapping("/showAcademies/{id}")
////    public ResponseEntity<List<ItaAcademy>> getAllItaAcademyByAcademyId(@PathVariable("id") int id) {
////        List<ItaAcademy> list = itaAcademyService.getAllItaAcademyByAcademy(id);
////        if (list == null) {
////            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
////        } else {
////            return new ResponseEntity<>(list, HttpStatus.OK);
////        }
////    }
//
//}
