package ua.softserve.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.softserve.persistence.entity.History;

import java.util.List;

public interface HistoryRepository extends JpaRepository<History, Integer> {

    List<History> findByAcademyId(int academyId);

    List<History> findAll();

    @Modifying
    @Query("UPDATE History h set h.modifyBy =:modifyBy where h.academyId =:academyId and h.modifyBy is null")
    void addModifyBy(@Param("modifyBy") String modifyBy, @Param("academyId") Integer academyId);

}
