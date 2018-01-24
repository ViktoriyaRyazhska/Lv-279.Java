package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select u.* from users as u join students as s on u.id = s.user_id join ita_academy as ia " +
            "on u.id = ia.user_id where ia.it_academy_status_id = :academyStatus and s.removed = true " +
            "and  ia.academy_id = :academyId group by u.id order by u.id;", nativeQuery = true)
    List<User> findAllByAcademyAndStatus(@Param("academyId") Integer academyId,
                                         @Param("academyStatus") Integer academyStatus);
}
