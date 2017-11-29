/*
* City
*
* Version 1.0-SNAPSHOT
*
* 15.11.17
*
* All rights reserved by DoubleO Team (Team#1)
* */

package ua.softserve.service;

import ua.softserve.persistence.entity.City;

import java.util.List;

public interface CityService {

    void save(City city);

    City findOne(int id);

    List<City> findAll();

    void remove(City city);

}
