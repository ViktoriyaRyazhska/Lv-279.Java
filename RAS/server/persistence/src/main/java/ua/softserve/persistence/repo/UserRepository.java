package ua.softserve.persistence.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.User;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query("select u from User u where FUNCTION('CONVERT', u.id, CHAR(10)) like :id "
            + "and u.id not in (select s.user.id from Student s where s.academy.id = :academyId and s.removed = false)")
    Page<User> findByIdAndName(@Param("id") String id, @Param("academyId") Integer notInAcademy, Pageable pageable);

    @Query(value = "select * from users as u where u.id not in (" + "select s.user_id from students as s "
            + "where s.academy_id =:academyId );", nativeQuery = true)
    List<User> findAllByAcademy(@Param("academyId") Integer academyId);
}
