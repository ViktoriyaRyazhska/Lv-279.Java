package ua.softserve;

import ua.softserve.data.entity.Academy;
import ua.softserve.repository.dao.AcademyDAO;
import ua.softserve.repository.dao.impl.AcademyDAOImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        AcademyDAO academyDAO = new AcademyDAOImpl();

//        List<Academy> academies = academyDAO.getAllAcademys();
//        academies.forEach(System.out::println);

        System.out.println(academyDAO.getById((Integer) 1));
    }
}