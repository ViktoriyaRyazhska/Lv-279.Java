/*
* CityServiceImpl
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import ua.softserve.persistence.dao.CityDAO;
import ua.softserve.persistence.entity.City;
import ua.softserve.service.CityService;

import java.util.List;

@Component
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDAO cityDAO;

    @Override
    @Transactional
    public void save(City city) {
        cityDAO.save(city);
    }

    @Override
    @Transactional(readOnly = true)
    public City findOne(int id) {
        return cityDAO.findOne(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<City> findAll() {
        return cityDAO.findAll();

    }

    @Override
    @Transactional
    public void remove(City city) {
        cityDAO.delete(city);
    }

}
