package ua.softserve.controller;

import org.hibernate.annotations.SQLDeleteAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.History;
import ua.softserve.service.HistoryService;

import java.util.List;

@Controller
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @GetMapping("/showHistory")
    public String showHistory(Model model) {
        List<History> allHistory = historyService.findAll();
        model.addAttribute("allHistory", allHistory);
        return "showHistory";
    }

    @RequestMapping(value = "/history/{id}", method = RequestMethod.GET, produces = "application/json")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity<List<History>> getHistory(@PathVariable int id) {
        return new ResponseEntity<List<History>>(historyService.findByAcademyId(id), HttpStatus.OK);
    }
}
