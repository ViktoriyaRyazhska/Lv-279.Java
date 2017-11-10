package ua.softserve.repository.dao;


import ua.softserve.data.entity.City;

import java.util.List;

public interface CityDAO {
    void save(City city);
    void update(City city);
    void delete(int id);

    City getById(int id);
    List<City> getListUsers();
}
