package ua.softserve.service;

import ua.softserve.dto.FeedbackDTO;
import ua.softserve.persistence.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    List<Feedback> findAll();
    void saveDTO(FeedbackDTO feedbackDTO);
}
