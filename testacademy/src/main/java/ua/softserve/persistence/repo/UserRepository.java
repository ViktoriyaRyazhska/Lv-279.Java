package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.GroupInfo;
import ua.softserve.persistence.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {
}
