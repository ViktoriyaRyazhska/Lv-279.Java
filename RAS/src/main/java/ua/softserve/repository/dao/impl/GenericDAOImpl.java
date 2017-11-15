/*
* GenericDAO
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.repository.dao.impl;

import org.hibernate.Session;
import ua.softserve.repository.dao.GenericDAO;
import ua.softserve.util.HibernateUtil;

import java.io.Serializable;
import java.util.List;

public class GenericDAOImpl<T, PK extends Serializable> implements GenericDAO<T, PK> {

    private Class<T> clazz;

    public GenericDAOImpl(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public PK save(T o) {
        PK id = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            id = (PK) session.save(o);
            session.getTransaction().commit();
        }
        return id;
    }

    @Override
    public void update(T o) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.update(o);
            session.getTransaction().commit();
        }
    }

    @Override
    public T findById(PK id) {
        T res = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            res = session.find(clazz, id);
            session.getTransaction().commit();
        }
        return res;
    }

    @Override
    public List<T> findAll() {
        List<T> res = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            res = session.createCriteria(clazz).list();
            session.getTransaction().commit();
        }
        return res;
    }

    @Override
    public void delete(T o) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.getTransaction().begin();
            session.delete(o);
            session.getTransaction().commit();
        }
    }
}
