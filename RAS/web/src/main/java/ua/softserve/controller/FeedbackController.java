package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ua.softserve.persistence.entity.Feedback;
import ua.softserve.service.FeedbackService;

import java.util.List;

@Controller
public class FeedbackController {
    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/showFeedbacks")
    public String showFeedbacks(Model model) {
        List<Feedback> allFeedback = feedbackService.findAll();
        model.addAttribute("allFeedback", allFeedback);
        return "showFeedbacks";
    }
}
