package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Feedback;
import ua.softserve.persistence.repo.FeedbackRepository;
import ua.softserve.service.FeedbackService;
import ua.softserve.service.dto.FeedbackDTO;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    @Transactional
    @Override
    public List<Feedback> findAll() {
        return feedbackRepository.findAll();
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

        feedbackRepository.save(feedback);
    }

    @Override
    public Feedback findOne(int id) {
        return feedbackRepository.findOne(id);
    }
}
