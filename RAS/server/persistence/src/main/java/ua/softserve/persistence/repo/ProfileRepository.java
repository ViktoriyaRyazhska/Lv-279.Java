package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.ProfileInfo;

public interface ProfileRepository extends JpaRepository<ProfileInfo, Integer> {

}
