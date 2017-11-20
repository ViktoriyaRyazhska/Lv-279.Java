package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.Profile;

public interface ProfileDAO extends JpaRepository<Profile, Integer> {
}
