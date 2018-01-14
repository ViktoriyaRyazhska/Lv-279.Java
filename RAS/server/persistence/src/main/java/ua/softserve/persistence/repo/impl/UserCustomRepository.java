package ua.softserve.persistence.repo.impl;

import org.springframework.stereotype.Repository;
import ua.softserve.persistence.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserCustomRepository {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Method returns list of users that belong to specific group.
     *
     * @return list of users.
     */
    public List<User> findUsersForGroup(Integer academyId, Integer academyStatus) {
        Query query = entityManager.createNamedStoredProcedureQuery("findUsers");
        query.setParameter("academyId", academyId);
        query.setParameter("academyStatus", academyStatus);
        return query.getResultList();
    }
}
