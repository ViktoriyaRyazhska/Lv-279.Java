package ua.softserve.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.softserve.persistence.entity.Feedback;
import ua.softserve.service.FeedbackService;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("feedback")
public class FeedbackController {
    private final Logger logger = LoggerFactory.getLogger(FeedbackController.class.getName());

    @Autowired
    FeedbackService feedbackService;

    @PutMapping("update")
    public ResponseEntity updateFeedback(@RequestBody Feedback feedback) {
        try {
            feedbackService.updateFeedback(feedback);
            logger.info("Update feedback with id: " + feedback.getId());
            return new ResponseEntity(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Feedback with id " + feedback.getId() + " not found");
        }
    }

    @PutMapping("update_comment/{studentId}")
    public ResponseEntity updateInterviewerComment(@RequestBody String comment, @PathVariable("studentId") Integer studentId) {
        try {
            feedbackService.updateInterviewerComment(comment, studentId);
            logger.info("Update student with id: " + studentId);
            logger.info("Comment " + comment);
            return new ResponseEntity(HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Student with id " + studentId + " not found");
        }
    }
}
