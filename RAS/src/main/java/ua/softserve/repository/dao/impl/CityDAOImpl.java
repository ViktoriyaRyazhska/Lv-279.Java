/*
* City
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.repository.dao.impl;

import org.springframework.stereotype.Component;
import ua.softserve.data.entity.City;
import ua.softserve.repository.dao.CityDAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class CityDAOImpl implements CityDAO {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void save(City product) {
        em.persist(product);
    }

    @Override
    public City findOne(int id) {
        return em.find(City.class, id);
    }

    @Override
    public List<City> findAll() {
        return em.createQuery("SELECT p FROM City p").getResultList();
    }

    @Override
    public City update(City product) {
        return em.merge(product);
    }

    @Override
    public void remove(City product) {
        em.remove(product);
    }

}
