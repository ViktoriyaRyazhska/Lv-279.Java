package ua.softserve.repository.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.softserve.data.entity.Academy;
import ua.softserve.repository.dao.AcademyDAO;
import ua.softserve.util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

public class AcademyDAOImpl implements AcademyDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }


    @Override
    public Academy getById(Integer id) {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        Academy academy = (Academy) getCurrentSession().get(Academy.class, id);
        if (academy == null) {
            System.out.println("Can't find the User where id = " + id);
        }
        transaction.commit();
        return academy;
    }

    @Override
    public List<Academy> getAllAcademys() {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        List<Academy> academies = new ArrayList<>(getCurrentSession().createCriteria(Academy.class).list());
        transaction.commit();

        return academies;
    }
}
