package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.service.dto.FeedbackDTO;
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

    @Transactional
    @Override
    public void saveDTO(FeedbackDTO feedbackDTO) {
        Feedback feedback = new Feedback();

        feedback.setLearningAbility(feedbackDTO.getLearningAbility());
        feedback.setActiveCommunicator(feedbackDTO.getActiveCommunicator());
        feedback.setGettingThingsDone(feedbackDTO.getGettingThingsDone());
        feedback.setOverallTechnicalCompetence(feedbackDTO.getOverallTechnicalCompetence());
        feedback.setPassionalInitiative(feedbackDTO.getPassionalInitiative());
        feedback.setTeamWork(feedbackDTO.getTeamWork());
        feedback.setSummary(feedbackDTO.getSummary());

        feedbackDAO.save(feedback);
    }

    @Override
    public Feedback findOne(int id) {
        return feedbackDAO.findOne(id);
    }
}
