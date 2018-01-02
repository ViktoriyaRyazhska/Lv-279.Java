package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.User;

import java.util.List;



public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "select * from users as u where u.id in (select ia.user_id from ita_academy as ia " +
            "where ia.academy_id =:academyId and ia.it_academy_status_id =:academyStatus)" +
            "and u.id not in (select s.user_id from students as s " +
            "where s.academy_id =:academyId and s.removed = false);", nativeQuery = true)
    List<User> findAllByAcademyAndStatus(@Param("academyId") Integer academyId, @Param("academyStatus") Integer academyStatus);
}
