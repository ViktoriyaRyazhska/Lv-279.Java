package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
