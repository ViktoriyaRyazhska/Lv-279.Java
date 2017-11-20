package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
}
