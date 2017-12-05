package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.LoginUser;

public interface LoginUserRepository extends JpaRepository<LoginUser,Integer>{
    LoginUser findLoginUserByUsername(String username);
}
