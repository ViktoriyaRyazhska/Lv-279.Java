package ua.softserve;

import ua.softserve.data.entity.City;
import ua.softserve.data.entity.Country;
import ua.softserve.repository.dao.GenericDAO;
import ua.softserve.repository.dao.impl.GenericDAOImpl;

public class Main {
    public static void main(String[] args) {

        City city1 = new City();
        city1.setName("Lviv");

        Country country1 = new Country();
        country1.setName("Ukraine");
        country1.setIta(true);

        city1.setCountry(country1);
        city1.setIta(true);

        GenericDAO cityDAO = new GenericDAOImpl(City.class);
        GenericDAO countryDAO = new GenericDAOImpl(Country.class);

        countryDAO.save(country1);
        cityDAO.save(city1);

    }
}