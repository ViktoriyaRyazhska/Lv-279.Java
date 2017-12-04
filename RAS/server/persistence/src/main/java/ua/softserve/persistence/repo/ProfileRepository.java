package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ua.softserve.persistence.entity.ProfileInfo;

import java.util.List;

public interface ProfileRepository extends JpaRepository<ProfileInfo, Integer> {
    @Query("select p.profileName from ProfileInfo p")
    List<String> findProfileNames();
}
