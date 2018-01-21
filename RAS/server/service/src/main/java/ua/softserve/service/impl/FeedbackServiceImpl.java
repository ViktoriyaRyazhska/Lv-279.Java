package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.Feedback;
import ua.softserve.persistence.entity.Student;
import ua.softserve.persistence.repo.FeedbackRepository;
import ua.softserve.persistence.repo.StudentRepository;
import ua.softserve.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService{
    @Autowired
    private FeedbackRepository feedbackRepository;

    @Autowired
    private StudentRepository studentRepository;

    /**
     * Update student feedback.
     *
     * @param feedback - student feedback.
     */
    @Override
    @Transactional
    public void updateFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }

    /**
     * Update student interviewer comment.
     *
     * @param comment - interviewer comment.
     * @param studentId - student id.
     */
    @Override
    @Transactional
    public void updateInterviewerComment(String comment, Integer studentId) {
        Student existStudent = studentRepository.findOne(studentId);
        existStudent.getData().setInterviewerComment(comment);
        studentRepository.save(existStudent);
    }
}
