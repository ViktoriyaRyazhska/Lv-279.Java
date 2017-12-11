package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.softserve.persistence.entity.LoginUser;

import java.util.Optional;

public interface LoginUserRepository extends JpaRepository<LoginUser, Integer> {

    Optional<LoginUser> findLoginUserByUsername(String username);
}
