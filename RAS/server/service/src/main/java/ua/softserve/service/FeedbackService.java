package ua.softserve.service;


import ua.softserve.persistence.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    /**
     * Update feedback of Student.
     */
    void updateFeedback(Feedback feedback);

    /**
     * Update interviewer comment of Student.
     */
    void updateInterviewerComment(String comment, Integer studentId);
}
