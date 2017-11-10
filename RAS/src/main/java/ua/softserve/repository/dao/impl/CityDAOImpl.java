package ua.softserve.repository.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import ua.softserve.data.entity.City;
import ua.softserve.repository.dao.CityDAO;
import ua.softserve.util.HibernateUtil;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Transactional
public class CityDAOImpl implements CityDAO {
    private SessionFactory sessionFactory = HibernateUtil.getSessionFactory();


    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(City city) {
//        if(isExist(city.getCityName())){
//            System.out.println("User with login \""+city.getCityName()+"\" already exist.");
//        }else {
        getCurrentSession().saveOrUpdate(city);
//        }
    }

    @Override
    public void update(City city) {
        if (city != null) {
            getCurrentSession().saveOrUpdate(city);
        }
    }

    @Override
    public void delete(int id) {
        City city = getById(id);

        if (city == null) {
            System.out.println("Can't find the User where id = " + id);
        } else {
            getCurrentSession().delete(city);
        }
    }

    @Override
    public City getById(int id) {
        Transaction transaction = sessionFactory.getCurrentSession().beginTransaction();
        City city = (City) getCurrentSession().get(City.class, id);
        if (city == null) {
            System.out.println("Can't find the User where id = " + id);
        }
        transaction.commit();
        return city;
    }


    @Override
    public List<City> getListUsers() {
        return new ArrayList<>(getCurrentSession().createCriteria(City.class).list());
    }
}
