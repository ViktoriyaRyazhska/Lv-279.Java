package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Feedback;

import java.util.List;

public interface FeedbackDAO extends JpaRepository<Feedback, Integer> {

}
