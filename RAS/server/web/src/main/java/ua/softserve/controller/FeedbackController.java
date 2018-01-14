package ua.softserve.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.Feedback;
import ua.softserve.service.FeedbackService;

import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedbackController {
    @Autowired
    FeedbackService feedbackService;

    @PutMapping("update")
    public ResponseEntity updateFeedback(@RequestBody Feedback feedback) {
        feedbackService.updateFeedback(feedback);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping("update_comment/{studentId}")
    public ResponseEntity updateInterviewerComment(@RequestBody String comment, @PathVariable("studentId") Integer studentId) {
        feedbackService.updateInterviewerComment(comment, studentId);
        System.out.println(comment);
        return new ResponseEntity(HttpStatus.OK);
    }
}
