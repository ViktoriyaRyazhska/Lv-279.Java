package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.FeedbackDAO;
import ua.softserve.persistence.entity.Feedback;
import ua.softserve.service.FeedbackService;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackDAO feedbackDAO;

    @Transactional
    @Override
    public List<Feedback> findAll() {
        return feedbackDAO.findAll();
    }
}
