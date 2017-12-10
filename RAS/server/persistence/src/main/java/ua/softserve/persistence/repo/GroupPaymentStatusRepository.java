package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.GroupPaymentStatus;

@Repository
public interface GroupPaymentStatusRepository extends JpaRepository<GroupPaymentStatus, Integer> {
}
