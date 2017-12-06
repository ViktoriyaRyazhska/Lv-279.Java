package ua.softserve.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.softserve.persistence.entity.Profile;

import java.util.List;

public interface ProfileDAO extends JpaRepository<Profile, Integer> {
    @Query("select p.profileName from Profile p")
    List<String> findProfileNames();
}
