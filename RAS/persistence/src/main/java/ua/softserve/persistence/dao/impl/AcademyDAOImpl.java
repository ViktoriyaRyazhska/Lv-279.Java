package ua.softserve.persistence.dao.impl;

import org.springframework.stereotype.Repository;
import ua.softserve.persistence.dao.AcademyDAO;
import ua.softserve.persistence.entity.Academy;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class AcademyDAOImpl implements AcademyDAO {
    @PersistenceContext
    private EntityManager em;

    @Override
    public Academy getById(Integer id) {
        return em.find(Academy.class, id);
    }

    @Override
    public List<Academy> getAllAcademys() {
        CriteriaQuery<Academy> criteriaQuery = em.getCriteriaBuilder().createQuery(Academy.class);
        @SuppressWarnings("unused")
        Root<Academy> root = criteriaQuery.from(Academy.class);
        return em.createQuery(criteriaQuery).getResultList();
    }
}
